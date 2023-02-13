public class planet extends solarbody {
    
    /**
     * Constructor for planet object
     * @param distanceTemp double value for distance of planet from centre
     * @param angleTemp double value of angle of planet from centre
     * @param diameterTemp double value for diameter of planet
     * @param colTemp string value for colour of planet
     * @param orbitSpeedTemp double value for speed at which planet orbits
     */
    public planet(String nameTemp, double distanceTemp, double angleTemp, double diameterTemp, String colTemp, double orbitSpeedTemp)
    {
        super(nameTemp, distanceTemp, angleTemp, diameterTemp, colTemp, orbitSpeedTemp);
    }

    /**
     * Moves planet and displays new location on screen
     * @param s Reference to object of solar system class where planet will be displayed
     */
    public void move(SolarSystem s, solarbody[] systemarray)
    {
        super.move(s, systemarray);
        s.drawSolarObject(this.getdistance(), this.getangle(), this.getdiameter(), this.getcol());

    }
}
