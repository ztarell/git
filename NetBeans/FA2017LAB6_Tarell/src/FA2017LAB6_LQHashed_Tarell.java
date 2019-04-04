/*
 * LQHashed Data Structure Class
    By Zachary Tarell
    11/6/2017
 */
import java.io.*;

public class FA2017LAB6_LQHashed_Tarell {

    int N;
    int n = 0; //the number of Nodes in the structure
    int defaultQuotient = 9967; //the default 4k + 3 prime
    double loadingFactor = 0.75;
    FA2017LAB6_Employee_Tarell deleted; // the dummy node, v2 (v1 = null)
    private FA2017LAB6_Employee_Tarell[] data; // primary storage array

    public FA2017LAB6_LQHashed_Tarell(int length) {
        int pct = (int) ((1.0 / loadingFactor - 1) * 100.0);
        N = fourKPlus3(length, pct);
        data = new FA2017LAB6_Employee_Tarell[N];
        deleted = new FA2017LAB6_Employee_Tarell("", "", "", "", 0);
        for (int i = 0; i < N; i++) {
            data[i] = null;
        }
    }// end of constructor

    public boolean insert(FA2017LAB6_Employee_Tarell newEmployee) {
        boolean noError;
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(newEmployee.getKey()); // preprocess the key
        if ((((double) n) / N) < loadingFactor) { // insert the node
            pass = 0;
            q = pk / N;
            offset = q;
            ip = pk % N;
            if (q % N == 0) {
                offset = defaultQuotient;
            }
            while (pass < N) {
                if (data[ip] == null || data[ip] == deleted) {
                    hit = true;
                    break;
                }
                ip = (ip + offset) % N;
                pass = pass + 1;
            } // end while
            if (hit == true) {// insert the node
                data[ip] = newEmployee.deepCopy();
                n++;
                return noError = true;
            } else {
                return noError = false;
            }
        } else // structure full to loading factor, insert not performed
        {
            return noError = false;
        }
    } // end of insert method

    public FA2017LAB6_Employee_Tarell fetch(String targetKey) {
        boolean noError;
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(targetKey); // preprocess the key
        pass = 0;
        q = pk / N;
        offset = q;
        ip = pk % N;
        if (q % N == 0) {
            offset = defaultQuotient;
        }
        while (pass < N) {
            if (data[ip] == null) // node not in structure
            {
                break;
            }
            if (data[ip].compareTo(targetKey) == 0) {// node found
                hit = true;
                break;
            }
            ip = (ip + offset) % N; // collision occurred
            pass = pass + 1;
        } // end while
        if (hit == true) // return a deep copy of the node
        {
            return data[ip].deepCopy();
        } else {
            return null;
        }
    } // end of fetch method

    public boolean delete(String targetKey) {
        boolean noError;
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(targetKey); // preprocess the key
        pass = 0;
        q = pk / N;
        offset = q;
        ip = pk % N;
        if (q % N == 0) {
            offset = defaultQuotient;
        }
        while (pass < N) {
            if (data[ip] == null) // node not in structure
            {
                break;
            }
            if (data[ip].compareTo(targetKey) == 0) {// node found
                hit = true;
                break;
            }
            ip = (ip + offset) % N; // collision occurred
            pass = pass + 1;
        } // end while
        if (hit == true) { // delete the node
            data[ip] = deleted;
            n--;
            return noError = true;
        } else {
            return noError = false;
        }
    } // end of delete method

    public boolean update(String targetKey, FA2017LAB6_Employee_Tarell newEmployee) {
        if (delete(targetKey) == false) {
            return false;
        } else if (insert(newEmployee) == false) {
            return false;
        }
        return true;
    } // end of update method

    public void showAll() {
        for (int i = 0; i < N; i++) {
            if (data[i] != null && data[i] != deleted) {
                System.out.println(data[i].toString());
            }
        }
    } // end of showAll method

    public void showInFile(FileWriter fwriter) {
        try {
            for (int i = 0; i < N; i++) {
                if (data[i] != null && data[i] != deleted) {
                    fwriter.write(data[i].toFile() + "\r\n");
                }
            }
        } catch (IOException ioe) {
            System.err.println(" IOException: " + ioe.getMessage());
        }
    }

    public static int fourKPlus3(int n, int pct) {
        boolean fkp3 = false;
        boolean aPrime = false;
        int prime, highDivisor, d;
        double pctd = pct;
        prime = (int) (n * (1.0 + (pctd / 100.0))); //guess the prime pct, percent larger than n
        if (prime % 2 == 0) // if even, make the prime guess odd
        {
            prime = prime + 1;
        }
        while (fkp3 == false) { // not a 4k + 3 prime
            while (aPrime == false) { // not a prime
                highDivisor = (int) (Math.sqrt(prime) + 0.5);
                for (d = highDivisor; d > 1; d--) {
                    if (prime % d == 0) {
                        break;
                    }
                }
                if (d != 1) // prime not found
                {
                    prime = prime + 2;
                } else {
                    aPrime = true;
                }
            } // end of the prime search loop
            if ((prime - 3) % 4 == 0) {
                fkp3 = true;
            } else {
                prime = prime + 2;
                aPrime = false;
            }
        } // end of 4k + 3 prime search loop
        return prime;
    } // end of fourKPlus3 method

    public static int stringToInt(String aKey) {
        int pseudoKey = 0;
        int n = 1;
        int cn = 0;
        char c[] = aKey.toCharArray();
        int grouping = 0;
        while (cn < aKey.length()) { // still more characters in the key
            grouping = grouping << 8; // pack next 4 characters
            grouping = grouping + c[cn];
            cn = cn + 1;
            if (n == 4 || cn == aKey.length()) {// 4 characters are processed or no more characters
                pseudoKey = pseudoKey + grouping; // add grouping to pseudoKey
                n = 0;
                grouping = 0;
            }
            n = n + 1;
        } //end of while
        return Math.abs(pseudoKey);
    } // end of stringToInt method
} // end of class LQHashed
