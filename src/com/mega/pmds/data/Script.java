package com.mega.pmds.data;

import java.io.IOException;
import java.util.ArrayList;

import com.mega.pmds.CodeConverter;
import com.mega.pmds.RomManipulator;

public class Script {
    private ArrayList<Command> commands;

    public Script(int offset) {
        try {
            commands = interpretCode(offset);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Script(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public static ArrayList<Command> interpretCode(int offset) throws IOException {
		ArrayList<Command> output = new ArrayList<Command>();

		byte[] data = new byte[16];
		RomManipulator.seek(offset);
		do {
			long curCommandOffset = RomManipulator.getFilePointer();
			RomManipulator.read(data);
            try{
                Command c = new Command(data, curCommandOffset);
			    output.add(c);
				if(isTerminator(data[0]) && RomManipulator.peek()!=0xF4)
					break;
			}catch(IOException ioe) {
				ioe.printStackTrace();
				break;
			} catch(Exception e) {
                e.printStackTrace();
                break;
            }
		}while(true);
		return output;
	}

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    /**
     * Saves the current contents of the script to the opened ROM file.
     */
    public void saveCommands() {
        for(Command c : commands) {
            c.save();
        }
    }

    /**
     * Sets the contents of the Script from a newline delimited list of commands.
     * @param text The text to set the script from. Should be hex bytes and can have spaces. Commands are delimited by newlines.
     */
    public void setFromText(String text) {
        String[] lines = text.split("\n");
        if(commands.size() != lines.length) {
            System.err.println("The text has too many commands for the opened script.");
            return;
        }
        // Extract data from text
        for(int i = 0; i < lines.length; i++) {
            String line = lines[i];
            byte[] data = CodeConverter.stringToBytes(line);
            commands.get(i).setBytes(data);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Command command : this.commands) {
            sb.append(Long.toHexString(command.getAddress()) + "\t" + command.toString() + "\n");
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public String addressesToString() {
        StringBuilder sb = new StringBuilder();
        for (Command command : this.commands) {
            sb.append(String.format("0x%08x",command.getAddress()) + "\n");
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public String commandsToString() {
        StringBuilder sb = new StringBuilder();
        for (Command command : this.commands) {
            sb.append(command.toString() + "\n");
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private static boolean isTerminator(byte in) {
		int command = ((int)in)&0xFF;
		return (command==0xE7 || command==0xE9 || (0xEE<=command && command<=0xF1));
	}
}
