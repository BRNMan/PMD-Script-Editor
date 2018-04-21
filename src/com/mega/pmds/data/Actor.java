package com.mega.pmds.data;

public enum Actor {
	PLAYER(0X00),			PARTNER(0X22),			RANDOM_STARTER(0X24),	WARTORTLE(0X25),
	BLASTOISE_0(0X26),		MEOWTH(0X27),			LICKITUNG(0X28),		JIRACHI_0(0X29),
	HYPNO(0X2A),			NOCTOWL(0X2B),			METAPOD_0(0X2C),		JIRACHI_1(0X2D),
	WIGGLYTUFF_0(0X2E),		PELIPPER_0(0X2F),		PELIPPER_1(0X30),		PELIPPER_2(0X31),
	PELIPPER_3(0X32),		AZUMARILL(0X33),		BUTTERFREE(0X35),		CATERPIE(0X36),
	PELIPPER_4(0X37),		PELIPPER_5(0X38),		PELIPPER_6(0X3A),		PELIPPER_7(0X3B),
	MAGNEMITE_0(0X3C),		MAGNEMITE_1(0X3D),		MAGNEMITE_2(0X3E),		MEGNETON(0X3F),
	MAGNEMITE_3(0X40),		MAGNEMITE_4(0X41),		DUGTRIO_0(0X42),		DUGTRIO_1(0X43),
	DIGLETT(0X44),			SKARMORY(0X45),			GREEN_KECLEON(0X46),	PURPLE_KECLEON(0X47),
	PERSIAN(0X48),			WIGGLYTUFF_1(0X49),		GULPIN_0(0X4A),			KANGASKHAN(0X4B),
	GULPIN_1(0X4C),			LOMBRE(0X4D),			JUMPLUFF_0(0X4E),		BELLSPROUT(0X4F),
	SNUBBULL(0X50),			GRANBULL(0X51),			GARDEVOIR(0X52),		ABSOL(0X53),
	MAKUHITA(0X54),			SHIFTRY(0X55),			NUZLEAF_0(0X56),		NUZLEAF_1(0X57),
	ALAKAZAM(0X58),			CHARIZARD(0X59),		TYRANITAR(0X5A),		GENGAR(0X5B),
	EKANS(0X5C),			MEDICHAM(0X5D),			METAPOD_1(0X5E),		JUMPLUFF_1(0X5F),
	ZAPDOS(0X60),			XATU(0X61),				WISHCASH(0X62),			NINETAILS(0X63),
	DECOY(0X64),			MOLTRES(0X65),			ARTICUNO(0X66),			GROUDON(0X67),
	BLASTOISE_1(0X68),		OCTILLERY(0X69),		GOLEM(0X6A),			BLASTOISE_2(0X6B),
	RAYQUAZA(0X6C),			WYNAUT(0X6D),			WOBBUFFET(0X6E),		MANKEY_0(0X6F),
	MANKEY_1(0X70),			MANKEY_2(0X71),			MANKEY_3(0X72),			SPINDA(0X73),
	ENTEI(0X74),			RAIKOU(0X75),			SUICUNE(0X76),			HO_OH(0X77),
	MEWTWO(0X78),			LATIOS(0X79),			LATIAS(0X7A),			JIRACHI_2(0X7B),
	SMEARGLE_0(0X7C),		SMEARGLE_1(0X7D),		SMEARGLE_2(0X7E),		MUNCHLAX(0X7F),
	MEW(0X80),				REGIROCK(0X81),			REGICE(0X82),			REGISTEEL(0X83),
	KYOGRE(0X84),			LUGIA(0X85),			DEOXYS(0X86),			RAICHU(0X87),
	GOLBAT(0X88),			RHYDON(0X89),			MR_MIME(0X8A),			SCYTHER(0X8B),
	PINSIR(0X8C),			MEGANIUM(0X8D),			AIPOM(0X8E),			PHANPY(0X8F),
	MERCHANT_0(0X90),		MERCHANT_1(0X91),		DONPHAN(0X93);
	
	private int id;
	
	private Actor(int idIn) {
		this.id = idIn;
	}
	
	@Override
	public String toString() {
		String name = super.toString().toLowerCase();
		char[] temp = name.toCharArray();
		temp[0] = Character.toUpperCase(temp[0]);
		name = String.copyValueOf(temp);
		if(name.equals("Ho_oh"))
			name="Ho-oh";
		if(name.equals("Mr_mime"))
			name="Mr. Mime";
		if(name.equals("Green_kecleon"))
			name="Green Kecleon";
		if(name.equals("Purple_kecleon"))
			name="Purple Kecleon";
		name.replaceAll("_", " ");
		return name;
	}
	
	public static Actor fromID(int id) {
		for(Actor act : Actor.values()) {
			if ((act.id) == (id)) {
				return act;
			}
		}
		return null;
	}
}
