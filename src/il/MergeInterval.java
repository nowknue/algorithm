package il;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class Interval {
//   int start;
//   int end;
//
//   Interval() {
//      this.start = 0;
//      this.end = 0;
//   }
//
//   Interval(int s, int e) {
//      this.start = s;
//      this.end = e;
//   }
//}

public class MergeInterval {
   public static void main(String[] args) {
      MergeInterval a = new MergeInterval();

      Interval in1 = new Interval(2, 6);
      Interval in2 = new Interval(1, 3);
      Interval in3 = new Interval(8, 10);
      Interval in4 = new Interval(15, 18);

      List<Interval> intervals = new ArrayList<>();
      intervals.add(in1);
      intervals.add(in2);
      intervals.add(in3);
      intervals.add(in4);
      
      List<Interval> list = a.merge(intervals);
      
      System.out.println("===result===");
      a.print(list);
   }

   public List<Interval> merge(List<Interval> intervals) {
      if (intervals.isEmpty()) return intervals;
      
      //1
      List<Interval> result = new ArrayList<>();
      
      print(intervals);
      Collections.sort(intervals, (a, b) -> a.start - b.start);
      System.out.println("==========");
      print(intervals);
      //Collections.sort(intervals, Comp);
      
      //2
      Interval before = intervals.get(0);
      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);
         
         if (before.end >= current.start) {
            before.end = Math.max(before.end, current.end);
         } else {
            result.add(before);
            before = current;
         }
      }
      
      if (!result.contains(before)) {
         result.add(before);
      }
      
      return result;
   }
   
   Comparator<Interval> Comp = new Comparator<Interval>() {

      @Override
      public int compare(Interval o1, Interval o2) {
         return o1.start - o2.start;
      }
      
   };

   public void print(List<Interval> list) {
      for (int i = 0; i < list.size(); i++) {
         Interval in = list.get(i);
         System.out.println(in.start + " " + in.end);
      }
   }
}