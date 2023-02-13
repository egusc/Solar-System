public class moon extends solarbody {

    private String orbitingplanetstring;
    private solarbody orbitingplanet;
    /**
     * Constructor for moon object
     * @param distanceTemp double value for distance of moon from centre
     * @param angleTemp double value of angle of moon from centre
     * @param diameterTemp double value for diameter of moon
     * @param colTemp string value for colour of moon
     * @param orbitSpeedTemp double value for speed at which moon orbits
     * @param orbitingplanetTemp object reference to planet object that moon orbits
     */
    
    public moon(String nameTemp, double distanceTemp, double angleTemp, double diameterTemp, String colTemp, double orbitSpeedTemp, String orbitingplanetTemp)
    {
        super(nameTemp, distanceTemp, angleTemp, diameterTemp, colTemp, orbitSpeedTemp);
        orbitingplanetstring = orbitingplanetTemp;
    }

    /**
     * Returns string value of the name of the solar object this object is orbiting
     * @return string value of name of solar object this object is orbiting
     */
    public String getOrbitingPlanetString()
    {
        return orbitingplanetstring;
    }

    /**
     * Moves moon and displays new location on screen
     * @param s Reference to object of solar system class where moon will be displayed
     */
    public void move(SolarSystem s, solarbody[] systemarray)
    {
        super.move(s, systemarray); //runs move function in parent class to calculate new angle
        for(int i = 0; i < systemarray.length; i++)
        {
            //Try/catch to avoid null pointer errors
            try{
                //Finds planet moon should orbit and makes it the orbitingplanet
                if((systemarray[i].getName()).equals(orbitingplanetstring)) 
                {
                    orbitingplanet = systemarray[i];
                }
            }
            catch(Exception e)
            {
                continue;
            }
        }
        s.drawSolarObjectAbout(this.getdistance(), this.getangle(), this.getdiameter(), this.getcol(), orbitingplanet.getdistance(), orbitingplanet.getangle());

    }
}
