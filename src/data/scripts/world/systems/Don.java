/**
 * @ Author: Laroustine
 * @ Modified time: 22/04/2025 18:15
 * @ Modified by: Laroustine
 * @ Description: This script has been made by me ↖(^▽^)↗
 */

package data.scripts.world.systems;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.JumpPointAPI;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.StarTypes;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;
import com.fs.starfarer.api.util.Misc;

public class Don {

        final String faction = "gjallarhorn";

        public void generate(SectorAPI sector) {
                StarSystemAPI system = sector.createStarSystem("Don");
                PlanetAPI star = system.initStar(
                                "don",
                                StarTypes.ORANGE,
                                700,
                                -4500,
                                -8500,
                                100);
                // Agriculture
                PlanetAPI amaethon = system.addPlanet(
                                "amaethon",
                                star,
                                "Amaethon",
                                "terran",
                                260,
                                200,
                                7000,
                                320);
                // Forgeron
                PlanetAPI gofannon = system.addPlanet(
                                "gofannon",
                                star,
                                "Gofannon",
                                "rocky_metallic",
                                135,
                                140,
                                2000,
                                80);
                // Mother
                PlanetAPI arianrhod = system.addPlanet(
                                "arianrhod",
                                star,
                                "Arianrhod",
                                "water",
                                30,
                                310,
                                16000,
                                830);
                // Macicien
                PlanetAPI gwydion = system.addPlanet(
                                "gwydion",
                                star,
                                "Gwydion",
                                "gas_giant",
                                330,
                                360,
                                9000,
                                460);

                // InitMoons
                // Cerf
                PlanetAPI hyddwn = system.addPlanet(
                                "hyddwn",
                                gwydion,
                                "Hyddwn",
                                "arid",
                                15,
                                170,
                                1250,
                                95);
                // Sanglier
                PlanetAPI hychtwn = system.addPlanet(
                                "hychtwn",
                                gwydion,
                                "Hychtwn",
                                "cryovolcanic",
                                75,
                                160,
                                3600,
                                200);
                // Loup
                PlanetAPI bleiddwn = system.addPlanet(
                                "bleiddwn",
                                gwydion,
                                "bleiddwn",
                                "tundra",
                                285,
                                140,
                                4000,
                                220);
                // ???
                PlanetAPI dylan = system.addPlanet(
                                "dylan",
                                arianrhod,
                                "Dylan Eil Ton",
                                "lava_minor",
                                160,
                                80,
                                820,
                                20);
                // Long arm
                PlanetAPI llew = system.addPlanet(
                                "llew",
                                arianrhod,
                                "Llew Llaw Gyffes",
                                "irradiated",
                                300,
                                120,
                                4750,
                                320);

                // InitMarket Planet
                Misc.initConditionMarket(amaethon);
                Misc.initConditionMarket(gofannon);
                Misc.initConditionMarket(arianrhod);
                Misc.initConditionMarket(gwydion);
                // InitMarket
                Misc.initConditionMarket(hyddwn);
                Misc.initConditionMarket(hychtwn);
                Misc.initConditionMarket(bleiddwn);
                Misc.initConditionMarket(dylan);
                Misc.initConditionMarket(llew);

                // Market & Planet Info
                makeMarketWater(sector, arianrhod);
                makeMarketTerran(sector, amaethon);
                makeMarketMining(sector, hychtwn);

                // Utility
                system
                                .addCustomEntity("nav_buoy", "Nav Buoy", "nav_buoy", faction)
                                .setCircularOrbitPointingDown(star, -95, 1100, 23);
                system
                                .addCustomEntity("comm_relay", "Comm Relay", "comm_relay", faction)
                                .setCircularOrbitPointingDown(star, 107, 9000, 187);
                system
                                .addCustomEntity("sensor_array", "Sensor Relay", "sensor_array", faction)
                                .setCircularOrbitPointingDown(star, -18, 18000, 222);

                // Jumps
                arianrhod.setAutogenJumpPointNameInHyper(
                                arianrhod.getName() + " Jump-point");
                arianrhod.setSkipForJumpPointAutoGen(false);
                gwydion.setAutogenJumpPointNameInHyper(gwydion.getName() + " Jump-point");
                gwydion.setSkipForJumpPointAutoGen(false);
                JumpPointAPI jmp1 = Global
                                .getFactory()
                                .createJumpPoint("don_jmp_1", (system.getName() + " Jump-point"));
                jmp1.setCircularOrbit(star, 300, 18000, 340);
                system.addEntity(jmp1);
                JumpPointAPI jmp2 = Global
                                .getFactory()
                                .createJumpPoint("don_jmp_2", (arianrhod.getName() + " Jump-point"));
                jmp2.setCircularOrbit(arianrhod, 300, 1600, 127);
                system.addEntity(jmp2);

                // Decorations
                system.addAsteroidBelt(
                                star,
                                40,
                                2000,
                                300,
                                50,
                                130,
                                Terrain.ASTEROID_BELT,
                                "Gofannon's Residue");
                system.addRingBand(
                                star,
                                "misc",
                                "rings_ice0",
                                256f,
                                4,
                                new Color(0, 0, 139),
                                300,
                                2000,
                                120,
                                null,
                                null);
                system.addAsteroidBelt(
                                gwydion,
                                120,
                                3800,
                                800,
                                120,
                                240,
                                Terrain.ASTEROID_BELT,
                                "Gwydion's Cold Outside");
                system.addRingBand(
                                gwydion,
                                "misc",
                                "rings_ice0",
                                256f,
                                2,
                                new Color(0, 0, 139),
                                800,
                                3800,
                                170,
                                null,
                                null);

                // System Info
                Misc.setAllPlanetsSurveyed(system, true);
                system.autogenerateHyperspaceJumpPoints(true, false);
                system.updateAllOrbits();
        }

        void makeMarketWater(SectorAPI sector, PlanetAPI planet) {
                MarketAPI market = planet.getMarket();
                market.setFactionId(faction);
                market.setSize(6);
                market.setPlanetConditionMarketOnly(false);
                market.getTariff().modifyFlat("generator", 0.35f);
                market.addCondition(Conditions.POPULATION_6);
                market.addCondition(Conditions.REGIONAL_CAPITAL);
                market.addCondition(Conditions.URBANIZED_POLITY);
                market.addCondition(Conditions.FREE_PORT);
                market.addCondition(Conditions.HABITABLE);
                market.addCondition(Conditions.HIGH_GRAVITY);
                market.addCondition(Conditions.WATER_SURFACE);
                market.addCondition(Conditions.VOLTURNIAN_LOBSTER_PENS);
                market.addSubmarket(Submarkets.SUBMARKET_STORAGE);
                market.addSubmarket(Submarkets.SUBMARKET_BLACK);
                market.addSubmarket(Submarkets.SUBMARKET_OPEN);
                market.addSubmarket(Submarkets.GENERIC_MILITARY);
                market.addIndustry(Industries.POPULATION);
                market.addIndustry(Industries.HIGHCOMMAND);
                market.addIndustry(Industries.MEGAPORT);
                market.addIndustry(Industries.ORBITALSTATION_HIGH);
                market.addIndustry(Industries.AQUACULTURE);
                market.addIndustry(
                                Industries.ORBITALWORKS,
                                new ArrayList<String>(Arrays.asList("pristine_nanoforge")));
                planet.setMarket(market);
                sector.getEconomy().addMarket(market, false);
        }

        void makeMarketTerran(SectorAPI sector, PlanetAPI planet) {
                MarketAPI market = planet.getMarket();
                market.setFactionId(faction);
                market.setSize(6);
                market.setPlanetConditionMarketOnly(false);
                market.getTariff().modifyFlat("generator", 0.35f);
                market.addCondition(Conditions.POPULATION_6);
                market.addCondition(Conditions.HABITABLE);
                market.addCondition(Conditions.FARMLAND_BOUNTIFUL);
                market.addCondition(Conditions.ORGANICS_ABUNDANT);
                market.addCondition(Conditions.EXTREME_WEATHER);
                market.addSubmarket(Submarkets.SUBMARKET_STORAGE);
                market.addSubmarket(Submarkets.SUBMARKET_BLACK);
                market.addSubmarket(Submarkets.GENERIC_MILITARY);
                market.addIndustry(Industries.POPULATION);
                market.addIndustry(
                                Industries.MINING,
                                new ArrayList<String>(Arrays.asList("mantle_bore")));
                market.addIndustry(Industries.MEGAPORT);
                market.addIndustry(Industries.FARMING);
                market.addIndustry(Industries.LIGHTINDUSTRY);
                planet.setMarket(market);
                sector.getEconomy().addMarket(market, false);
        }

        void makeMarketMining(SectorAPI sector, PlanetAPI planet) {
                MarketAPI market = planet.getMarket();
                market.setFactionId(faction);
                market.setSize(5);
                market.setPlanetConditionMarketOnly(false);
                market.getTariff().modifyFlat("generator", 0.35f);
                market.addCondition(Conditions.POPULATION_5);
                market.addCondition(Conditions.NO_ATMOSPHERE);
                market.addCondition(Conditions.COLD);
                market.addCondition(Conditions.ORE_ABUNDANT);
                market.addCondition(Conditions.RARE_ORE_RICH);
                market.addCondition(Conditions.VOLATILES_TRACE);
                market.addCondition(Conditions.VOLATILES_TRACE);
                market.addSubmarket(Submarkets.GENERIC_MILITARY);
                market.addSubmarket(Submarkets.SUBMARKET_BLACK);
                market.addIndustry(Industries.POPULATION);
                market.addIndustry(Industries.MEGAPORT);
                market.addIndustry(Industries.MINING);
                market.addIndustry(
                                Industries.REFINING,
                                new ArrayList<String>(Arrays.asList("catalytic_core")));
                market.addIndustry(
                                Industries.FUELPROD,
                                new ArrayList<String>(Arrays.asList("synchrotron")));
                planet.setMarket(market);
                sector.getEconomy().addMarket(market, false);
        }
}
