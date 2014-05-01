/**
 * Created by Dylan on 1/05/2014.
 */
public class hwCalc {

    public static int atkShipCalculator(int atkWeapon, int defShip, int defWeapon)
    {
        int atkShip = 0;

        while (defShip > 0)
        {
            atkShip += (defWeapon + 1);
            defShip -= atkWeapon;
        }

        return atkShip + 1;
    }

    public static int atkWeaponCalculator(int atkShip, int defShip, int defWeapon)
    {
        int atkWeapon = 1;

        while(!wwCalc.winCalculator(atkShip, atkWeapon, defShip, defWeapon))
        {
            atkWeapon += 1;
        }

        return atkWeapon;
    }

    public static int defShipCalculator(int atkShip, int atkWeapon, int defWeapon)
    {
        int defShip = 0;

        while (atkShip > 0)
        {
            atkShip -= (defWeapon + 1);
            defShip += atkWeapon;
        }

        return defShip;
    }

    public static int defWeaponCalculator(int atkShip, int atkWeapon, int defShip)
    {
        int defWeapon = 1;

        while(wwCalc.winCalculator(atkShip, atkWeapon, defShip, defWeapon))
        {
            defWeapon += 1;
        }

        return defWeapon;
    }
}
