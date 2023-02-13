
public abstract class SolarSystemTask implements SolarSystemController {

    public static void main(String[] args) {
        SolarSystem s = new SolarSystem(800, 650); //Creates window for objects to be displayed on
        
        SolarSystemGUI gui = new SolarSystemGUI();  //Defines GUI
        sun solarsystemsun = new sun("solarsystemsun",0, 0, 50, "YELLOW", 0);   //Starts screen with a sun
        solarbody[] system = new solarbody[200];    //Creates array for all solarbody objects, including children classes
        system[0] = solarsystemsun;
        
        SolarSystemController mycontroller = new SolarSystemController() {
            int systemcounter = 1;

            /**
            * Adds planet to the system array based on user input into GUI
            * @param name string value for name of planet to be added
            * @param orbitalDistance double value for distance from the centre of the screen
            * @param initialAngle double value for angle of rotation that the planet starts at
            * @param size double value for diameter of the planet
            * @param speed double value for speed that the planet orbits the centre
            * @param colour string value for colour of the planet
            */
            public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour)
            {
                system[systemcounter] = new planet(name, orbitalDistance, initialAngle, size, colour, speed);
                systemcounter++;
            }
            /**
            * Adds moon to the system array based on user input into GUI
            * @param name string value for name of moon to be added
            * @param orbitalDistance double value for distance from the centre of the screen
            * @param initialAngle double value for angle of rotation that the moon starts at
            * @param size double value for diameter of the moon
            * @param speed double value for speed that the moon orbits the centre
            * @param colour string value for colour of the moon
            * @param parentName string value for object that moon orbits
            */
            public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour, String parentName)
            {
                system[systemcounter] = new moon(name, orbitalDistance, initialAngle, size, colour, speed, parentName);
                systemcounter++;
            }

            /**
            * Removes object from the system array based on user input into GUI
            * @param name string value for name of object to be removed
            */
            public void remove(String name)
            {
                for(int i = 0; i < system.length; i++)
                {
                    //Try/catch to avoid null pointer errors
                    try
                    {
                        if(system[i].getName().equals(name))
                        {
                            system[i] = null;   //Sets position in array to null so that it's not drawn on screen
                        }
                        if(system[i].getOrbitingPlanetString().equals(name))
                        {
                            system[i] = null;   //Removes any objects orbiting selected objects, as these will orbit empty space otherwise
                        }
                    }
                    catch(Exception e)
                    {
                        continue;
                    }
                }
            }
        };
        gui.addSolarSystemController(mycontroller); //Creates GUI
        system[1] = new planet("earth",60, 0, 6, "BLUE", 1);
        system[2] = new planet("mercury",35, 35, 4, "DARK_GRAY", 3);
        system[3] = new planet("venus",45, 50, 6, "GREEN", -2);
        system[4] = new planet("mars",85, 160, 5, "RED", 2);
        system[5] = new planet("jupiter",150, 85, 10, "ORANGE", 1);
        system[6] = new planet("saturn",225, 300, 9, "#964B00", 1.25);
        system[7] = new planet("uranus",300, 60, 8, "CYAN", -1);
        system[8] = new planet("neptune",375, 190, 8, "BLUE", 1.75);
        
        //Definitions for moons - planets must have been defined first
        system[9] = new moon("moon",7, 0, 2, "GRAY", 5, "earth");
        system[10] = new moon("phobos",5, 60, 2, "GRAY", 3, "mars");
        system[11] = new moon("deimos",7, 170, 2, "GRAY", 5, "mars");
        system[12] = new moon("io",10, 200, 2, "YELLOW", 4, "jupiter");
        system[13] = new moon("callisto",15, 30, 2, "DARK_GREY", 5, "jupiter");
        system[14] = new moon ("europa",20, 290, 2, "WHITE", 3, "jupiter");
        system[15] = new moon("ganymede",25, 165, 3, "GRAY", 4, "jupiter");
        system[16] = new moon("titan",10, 200, 3, "BLUE", 3, "saturn");
        system[17] = new moon("rhea",15, 20, 2, "GRAY", 4, "saturn");
        system[18] = new moon("iapetus",20, 330, 2, "GRAY", 2, "saturn");
        system[19] = new moon("dione",25, 170, 2, "GRAY", 5, "saturn");
        system[20] = new moon("miranda",10, 60, 2, "GRAY", 3, "uranus");
        system[21] = new moon("ariel",15, 120, 2, "GRAY", 2, "uranus");
        system[22] = new moon("umbriel",20, 240, 2, "GRAY", 5, "uranus");
        system[23] = new moon("titania",25, 300, 2, "GRAY", 4, "uranus");
        system[24] = new moon("oberon",30, 0, 2, "GRAY", 1, "uranus");
        system[25] = new moon("naiad",10, 35, 2, "GRAY",2, "neptune");
        system[26] = new moon("thalassa",15, 70, 2, "GRAY",4, "neptune");
        system[27] = new moon("despina",20, 320, 2, "GRAY",3, "neptune");
        system[28] = new moon("galatea",25, 250, 2, "GRAY",2, "neptune");

        while(true) 
        {
            
            for(int i = 0; i < system.length; i++)
            {
                    //Try/catch to avoid null pointer errors
                    try
                    {
                        system[i].move(s, system);
                    }
                    catch(Exception e)
                    {
                        continue;
                    }
            }
            s.finishedDrawing();
        }
    }
}
