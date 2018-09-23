package com.aa.travianbot.model;

public class BuildingsUtils {
    // ids
    public static final String G0 = "g0";
    public static final String G1 = "g1";
    public static final String G2 = "g2";
    public static final String G3 = "g3";
    public static final String G4 = "g4";
    public static final String G5 = "g5";
    public static final String G6 = "g6";
    public static final String G7 = "g7";
    public static final String G8 = "g8";
    public static final String G9 = "g9";
    public static final String G10 = "g10";
    public static final String G11 = "g11";
    public static final String G13 = "g13";
    public static final String G14 = "g14";
    public static final String G15 = "g15";
    public static final String G16 = "g16";
    public static final String G17 = "g17";
    public static final String G18 = "g18";
    public static final String G19 = "g19";
    public static final String G20 = "g20";
    public static final String G21 = "g21";
    public static final String G22 = "g22";
    public static final String G24 = "g24";
    public static final String G26 = "g26";
    public static final String G27 = "g27";
    public static final String G28 = "g28";
    public static final String G29 = "g29";
    public static final String G30 = "g30";
    public static final String G31 = "g31";
    public static final String G32 = "g32";
    public static final String G33 = "g33";
    public static final String G34 = "g34";
    public static final String G35 = "g35";
    public static final String G36 = "g36";
    public static final String G37 = "g37";
    public static final String G38 = "g38";
    public static final String G39 = "g39";
    public static final String G40 = "g40";
    public static final String G41 = "g41";

    // names
    public static final String EMPTY = "Empty";
    public static final String WOODCUTTER = "Woodcutter";
    public static final String CLAY_PIT = "Clay Pit";
    public static final String IRON_MINE = "Iron Mine";
    public static final String CROPLAND = "Cropland";
    public static final String SAWMILL = "Sawmill";
    public static final String BRICKYARD = "Brickyard";
    public static final String IRON_FOUNDRY = "Iron Foundry";
    public static final String GRAIN_MILL = "Grain Mill";
    public static final String BAKERY = "Bakery";
    public static final String WAREHOUSE = "Warehouse";
    public static final String GRANARY = "Granary";
    public static final String SMITHY = "Smithy";
    public static final String TOURNAMENT_SQUARE = "Tournament Square";
    public static final String MAIN_BUILDING = "Main Building";
    public static final String RALLY_POINT = "Rally Point";
    public static final String MARKETPLACE = "Marketplace";
    public static final String EMBASSY = "Embassy";
    public static final String BARRACKS = "Barracks";
    public static final String STABLE = "Stable";
    public static final String WORKSHOP = "Workshop";
    public static final String ACADEMY = "Academy";
    public static final String TOWN_HALL = "Town Hall";
    public static final String PALACE = "Palace";
    public static final String TREASURY = "Treasury";
    public static final String TRADE_OFFICE = "Trade Office";
    public static final String GREAT_BARRACKS = "Great Barracks";
    public static final String GREAT_STABLE = "Great Stable";
    public static final String CITY_WALL = "City Wall";
    public static final String EARTH_WALL = "Earth Wall";
    public static final String PALISADE = "Palisade";
    public static final String STONEMASON_S_LODGE = "Stonemason's Lodge";
    public static final String BREWERY = "Brewery";
    public static final String TRAPPER = "Trapper";
    public static final String HERO_S_MANSION = "Hero's Mansion";
    public static final String GREAT_WAREHOUSE = "Great Warehouse";
    public static final String GREAT_GRANARY = "Great Granary";
    public static final String WONDER_OF_THE_WORLD = "Wonder Of The World";
    public static final String HORSE_DRINKING_TROUGH = "Horse Drinking Trough";

    public static String buildingNameFromCode(String code) {
        switch (code) {
            case G0: return EMPTY;
            case G5: return SAWMILL;
            case G6: return BRICKYARD;
            case G7: return IRON_FOUNDRY;
            case G8: return GRAIN_MILL;
            case G9: return BAKERY;
            case G10: return WAREHOUSE;
            case G11: return GRANARY;
            case G13: return SMITHY;
            case G14: return TOURNAMENT_SQUARE;
            case G15: return MAIN_BUILDING;
            case G16: return RALLY_POINT;
            case G17: return MARKETPLACE;
            case G18: return EMBASSY;
            case G19: return BARRACKS;
            case G20: return STABLE;
            case G21: return WORKSHOP;
            case G22: return ACADEMY;
            case G24: return TOWN_HALL;
            case G26: return PALACE;
            case G27: return TREASURY;
            case G28: return TRADE_OFFICE;
            case G29: return GREAT_BARRACKS;
            case G30: return GREAT_STABLE;
            case G31: return CITY_WALL;
            case G32: return EARTH_WALL;
            case G33: return PALISADE;
            case G34: return STONEMASON_S_LODGE;
            case G35: return BREWERY;
            case G36: return TRAPPER;
            case G37: return HERO_S_MANSION;
            case G38: return GREAT_WAREHOUSE;
            case G39: return GREAT_GRANARY;
            case G40: return WONDER_OF_THE_WORLD;
            case G41: return HORSE_DRINKING_TROUGH;
            default: throw new RuntimeException("Unknown building code: " + code);
        }
    }

}
