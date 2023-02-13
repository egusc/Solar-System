public class solarbody {
    private String name;
    private double distance;
    private double angle;
    private double diameter;
    private String col;
    private double orbitSpeed;

    /**
     * Constructor for solarbody object
     * @param distanceTemp double value for distance of object from centre of screen
     * @param angleTemp double value for angle of object from centre of screen
     * @param diameterTemp double value for diameter of object
     * @param colTemp string value for colour of object
     * @param orbitSpeedTemp double value for the speed that the object orbits
     */
    public solarbody(String nameTemp, double distanceTemp, double angleTemp, double diameterTemp, String colTemp, double orbitSpeedTemp)
    {
        name = nameTemp;   
        distance = distanceTemp;
        angle = angleTemp;
        diameter = diameterTemp;
        col = colTemp;
        orbitSpeed = orbitSpeedTemp;
    }

    /**
     * Returns string value of the name of the solar object
     * @return string value of name of solar object
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns string value of the name of the solar object this object is orbiting
     * @return null by default
     */
    public String getOrbitingPlanetString()
    {
        return null;
    }
    /**
     * Returns distance of object from the centre
     * @return double value of distance
     */
    public double getdistance()
    {
        return distance;
    }
    /**
     * Returns angle of object from centre
     * @return double value of angle
     */
    public double getangle()
    {
        return angle;
    }

        /**
     * Returns diameter of object
     * @return double value of diameter
     */
    public double getdiameter()
    {
        return diameter;
    }

    /**
     * Returns colour of object
     * @return string value for colour of object
     */
    public String getcol()
    {
        return col;
    }
    
    /**
     * Determines where object should move to on screen
     * @param s Reference to object of solar system class where solar system will be displayed
     */
    public void move(SolarSystem s, solarbody[] systemarray)
    {
        if(angle < 0)
        {
            angle = 359;
        }
        if(angle > 359)
        {
            angle = 0;
        }
        else
        {
            angle = angle - orbitSpeed;
        }
    }
}
