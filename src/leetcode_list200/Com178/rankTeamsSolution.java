package leetcode_list200.Com178;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-01
 */
public class rankTeamsSolution {
    public String rankTeams(String[] votes) {
        int l=votes.length, al=votes[0].length();
        int[][] countAb=new int[l+1][al];
        String[] alphabat=new String[al];
        char[] ab=votes[0].toCharArray();
        char[] res=new char[al];
        Arrays.sort(ab);
        for (int i = 0; i < l; i++) {
            char[] tmp=votes[i].toCharArray();
            for (int j = 0; j < al; j++) {

                for (int k = 0; k < ab.length; k++) {
                    if(tmp[j]==ab[k]){
                        countAb[i][k]=j;
                        break;
                    }

                }

//                countAb[i][j]=votes[i].toCharArray()[]
            }
        }

            for (int j = 0; j < al; j++) {
                for (int i = 0; i < l; i++)
                {  countAb[l][j]+=countAb[i][j];
                }
            }
        int index=0;
        boolean[] vi=new boolean[al];
        for (int i = 0; i < al; i++) {
            int min=Integer.MAX_VALUE;
            int minIndex=0;

            for (int j = 0; j <al; j++) {
                if(countAb[l][j]<min&&!vi[j]){
                    min=countAb[l][j];
                    minIndex=j;
                }
            }
            vi[minIndex]=true;

            res[index++]=ab[minIndex];
        }



        return String.valueOf(res);



    }

    public static void main(String[] args) {
        rankTeamsSolution r = new rankTeamsSolution();
//        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
//                String[] votes = {"M","M","M","M"};
//        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        String[] votes={"WXYZ","XYZW"};

        System.out.println( r.rankTeams(votes));

    }
}
