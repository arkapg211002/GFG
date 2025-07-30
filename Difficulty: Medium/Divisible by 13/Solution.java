class Solution {
    public boolean divby13(String s) {
        // code here
        int n = s.length();
        if(n==0)return true;
        StringBuilder st = new StringBuilder();
        for(int i = 0;i<n;i++)
        {
            st.append(s.charAt(i));
            while(i+1<n&&Integer.parseInt(st.toString())<13)
            {
                i++;
                st.append(s.charAt(i));
            }
            int num = Integer.parseInt(st.toString());
            int k = num%13;
            if(k!=0)
            {
                st = new StringBuilder(String.valueOf(k));
            }
            else{
                st = new StringBuilder();
            }
        }
        return st.length()==0;
    }
}
