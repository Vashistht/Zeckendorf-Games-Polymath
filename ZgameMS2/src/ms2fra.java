import java.util.ArrayList;

/*
represent coefficients with decimals, might not be precise due to the way Double works
gives the bound with decimals only
works for larger numbers (30000+)
 */

public class ms2fra {
    public int count;
    public ArrayList<Double> MC;
    public ArrayList<Double> MS;

    public ms2fra() {
        //ms2<=(c1+s4-c2-c3)/2
        MC = new ArrayList<>();
        MS = new ArrayList<>();
        MS.add(0.0); //ms0
        MS.add(0.0); //ms1
        MS.add(0.0); //ms2
        MS.add(0.0); //ms3
        MS.add(1.0/2); //ms4
        MC.add(0.0); //mc0
        MC.add(1.0/2); //mc1
        MC.add(-1.0/2); //mc2
        MC.add(-1.0/2); //mc3
        count = 1;
    }

    /**
     * expand all MS term for n times
     * @param n
     */
    public void split(int n) {
        for (; n > 0; n--) {
            // adjust list length
            MS.add(0.0);
            MS.add(0.0);
            MC.add(0.0);
            MC.add(0.0);

            int i = 3;
            while (i < MS.size()) {
                if (MS.get(i) <= 0.0) ++i;
                else {
                    MS.set(i - 1, MS.get(i - 1) + MS.get(i)/2);
                    MS.set(i + 2, MS.get(i + 2) + MS.get(i)/2);
                    MC.set(i - 1, MC.get(i - 1) + MS.get(i)/2);
                    MC.set(i, MC.get(i) - MS.get(i)/2);
                    MC.set(i + 1, MC.get(i + 1) - MS.get(i)/2);
                    MS.set(i, 0.0);
                    i += 3;
                }
            }
            ++count; //change denominator
        }
    }

    /**
     * Print out the current inequality for ms2
     */
    public void print() {
        System.out.print("MS2 <=( ");
        System.out.print(MC.get(1)+"MC1");
        for (int i = 2; i < MC.size(); ++i) {
            if (MC.get(i) > 0) System.out.print("+");
            System.out.print(MC.get(i) + "MC" + i);
        }
        System.out.println();
        for (int i = 1; i < MS.size(); ++i) {
            if (MS.get(i) > 0) {
                System.out.print("+" + MS.get(i) + "MS" + i);
            }
        }
        System.out.print(" )\n");
    }

    /**
     * calculate the current bound for MS2
     * @return bound
     */
    public double calcMS2() {
        for (int i = 1; i < MC.size(); ++i) {
            if (MC.get(i) > 0.5) {
                System.out.print("MC goes over 1");
                return 0.0;
            }
        }
        double max = 0;
        for (int i = 3; i < MS.size(); ++i) {
            max = Math.max(MS.get(i), max);
        }
        return (0.5 + max) / (1 - MS.get(2));
    }

    public static void main(String[] args) {
        ms2fra a = new ms2fra();
        a.split(901);   //how many rounds of replacing all ms
//        a.print();      //print the inequality
        System.out.print(a.calcMS2()+"n");      //print the bound as decimal
    }
}
