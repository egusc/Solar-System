public class sun extends solarbody {
    
    /**
     * Constructor for sun object
     * @param distanceTemp double value for distance of sun from centre
     * @param angleTemp double value of angle of sun from centre
     * @param diameterTemp double value for diameter of sun
     * @param colTemp string value for colour of sun
     * @param orbitSpeedTemp double value for speed at which sun orbits
     */
    public sun(String nameTemp, double distanceTemp, double angleTemp, double diameterTemp, String colTemp, double orbitSpeedTemp)
    {
        super(nameTemp, distanceTemp, angleTemp, diameterTemp, colTemp, orbitSpeedTemp);
    }
    /**
     * Displays sun on screen
     * @param s Reference to object of solar system class where sun will be displayed
     */
    public void move(SolarSystem s, solarbody[] systemarray)
    {
        s.drawSolarObject(this.getdistance(), this.getangle(), this.getdiameter(), this.getcol());
    }
}
