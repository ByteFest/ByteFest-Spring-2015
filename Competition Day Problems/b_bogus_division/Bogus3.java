// Three-digit form of the bogus division problem.
public class Bogus3
{
   static final boolean DEBUG = false; // Check for round-off errors on explicit division

   public static void main ( String[] args )
   {
      int d1, d2, d3, d4, d5, top1, bot1, top2, bot2;

      for ( d1 = 1; d1 < 10; d1++ )
         for ( d2 = 1; d2 < 10; d2++ )
            for ( d3 = 1; d3 < 10; d3++ )
               for ( d4 = 1; d4 < 10; d4++ )
                  for (d5 = 1; d5 < 10; d5++ )
                  {
                     if ( d1 == d4 ) continue;   // Eliminate xxx/xxx = xx/xx
                     top1 = d1*10+d2;
                     top2 = top1*10+d3;
                     bot1 = d4*10+d5;
                     bot2 = bot1+d3*100;
                     if ( top2 * bot1 == bot2 * top1 )
                        System.out.println ( top2 + " / " + bot2 + " = " + top1 + " / " + bot1 );
                  }
      if ( DEBUG )
         check();
   }

   static void check()
   {
      double d1, d2, d3, d4, d5, top1, bot1, top2, bot2;

      System.out.println();
      for ( d1 = 1; d1 < 10; d1++ )
         for ( d2 = 1; d2 < 10; d2++ )
            for ( d3 = 1; d3 < 10; d3++ )
               for ( d4 = 1; d4 < 10; d4++ )
                  for (d5 = 1; d5 < 10; d5++ )
                  {
                     if ( d1 == d4 ) continue;   // Eliminate xxx/xxx = xx/xx
                     top1 = d1*10+d2;
                     top2 = top1*10+d3;
                     bot1 = d4*10+d5;
                     bot2 = bot1+d3*100;
                     if ( top2 / bot2 == top1 / bot1 )
                        System.out.printf ( "%1.0f / %1.0f = %1.0f / %1.0f\n", top2, bot2, top1, bot1 );
                  }

   }

}
