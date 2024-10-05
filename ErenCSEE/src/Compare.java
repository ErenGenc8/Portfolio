public class Compare {
    public static void main(String[] args)
    {
        double[][] result_hash = new double[3][5];
        double[][] result_AVL = new double[3][5];
        result_hash[0][0] = 0.11581839999999981;
        result_hash[0][1] = 0.14985629999999087;
        result_hash[0][2] = 2.180610499998826;
        result_hash[0][3] = 10.634317700142912;
        result_hash[0][4] = 139.74364199629184;
        result_hash[1][0] = 0.04588790000000006;
        result_hash[1][1] = 0.08417199999999606;
        result_hash[1][2] = 1.1086996000001141;
        result_hash[1][3] = 10.152899600106393;
        result_hash[1][4] = 62.156348993569246;
        result_hash[2][0] = 0.04697460000000049;
        result_hash[2][1] = 0.06844949999999748;
        result_hash[2][2] = 0.9543916999996078;
        result_hash[2][3] = 10.207773500143976;
        result_hash[2][4] = 80.443840887225;

        result_AVL[0][0] = 0.07255179999999845;
        result_AVL[0][1] = 0.24503890000000048;
        result_AVL[0][2] = 0.8291025999994691;
        result_AVL[0][3] = 2.9884308999975353;
        result_AVL[0][4] = 24.47183110063997;
        result_AVL[1][0] = 0.020179599999999492;
        result_AVL[1][1] = 0.08692219999999584;
        result_AVL[1][2] = 0.4721907000000069;
        result_AVL[1][3] = 2.432695599998815;
        result_AVL[1][4] = 23.664317000618826;
        result_AVL[2][0] = 0.008579800000000068;
        result_AVL[2][1] = 0.061139899999998214;
        result_AVL[2][2] = 0.3105883000001023;
        result_AVL[2][3] = 2.4859144999986356;
        result_AVL[2][4] = 23.132983500601835;
        for(int i = 0; i<3;i++)
        {
            for(int j = 0; j<5; j++)
            {
                if(result_hash[i][j] < result_AVL[i][j])
                {
                    System.out.println(i +  " " + j + " "  + result_hash[i][j] + " " + result_AVL[i][j]);
                }
            }
        }
    }
}
