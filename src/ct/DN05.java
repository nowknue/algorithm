package ct;

// 고급 SQL 공부 필요
public class DN05 {
   
   public static void main(String args[]) {
      /*
      SELECT
          A.BRANCH_ID AS BRANCH_ID
          , COUNT(B.CAR_ID) AS '계약 건수'
      FROM
          EMPLOYEES A
          , SELLINGS B
      WHERE
          A.ID = B.EMPLOYEE_ID
      GROUP BY
          A.BRANCH_ID
      ORDER BY
          A.BRANCH_ID
       
       */
   }

}