/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juanylaura.algorithms;

import java.util.Arrays;

/**
 *
 * @author jara
 */
public class LPT {

    int[][] lpt(int[] jobs, int servers) {
        //init retValue
        int[][] retValue = new int[servers][];
        for (int i = 0; i < servers; i++) {
            retValue[i] = new int[0];
        }

        //int server time(s)
        int[] time = new int[servers];
        for (int i = 0; i < servers; i++) {
            time[i] = 0;
        }

        for (int fake = 0; fake < jobs.length; fake++) { //iterate pending jobs
            //find next item (greater job)
            int next_idx = 0;
            int next_val = jobs[0];

            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i] > next_val) {
                    next_idx = i;
                    next_val = jobs[i];
                }
            }
            jobs[next_idx] = -1; //reset it, take out of the array

            //I got the next job idx, so add it to first free
            //server
            int srv_idx = 0;
            int min_time = time[0];
            for (int s = 0; s < servers; s++) {
                if (time[s] < min_time) {
                    srv_idx = s;
                    min_time = time[s];
                }
            }

            time[srv_idx]+=next_val; //update the total time of srv_idx
            
            addToServer(retValue, srv_idx, next_idx);
        }

        return retValue;
    }

    private void addToServer(int[][] retValue, int srv_idx, int nxt_idx) {
        int[] tmp = retValue[srv_idx]; //just ref to make code cleaner
        
        if (tmp == null && tmp.length == 0) { //safety check to init array
            tmp = new int[1];
        } else {
            int[] oldtmp = new int[tmp.length + 1]; //new array
            System.arraycopy(tmp, 0, oldtmp, 0, tmp.length);
            tmp = oldtmp; //new reference
        }
        tmp[tmp.length - 1] = nxt_idx; //last one
        retValue[srv_idx] = tmp; //update ref
    }

}
