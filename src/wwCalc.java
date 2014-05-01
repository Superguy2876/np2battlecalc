/**
 * Created by Dylan on 1/05/2014.
 */
public class wwCalc
{
    public static boolean winCalculator(int atkShip, int atkWeapon, int defShip, int defWeapon)
    {

        while (atkShip > 0 && defShip > 0)
        {
            atkShip -= (defWeapon + 1);

            if (atkShip > 0)
            {
                defShip -= atkWeapon;
            }
        }
        return (defShip <= 0);
    }
}
