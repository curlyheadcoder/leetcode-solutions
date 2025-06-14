class Solution:
    def minMaxDifference(self, v: int) -> int:
        s = str(v)
        return int(s.replace((s+'_').lstrip('9')[0],'9'))-int(s.replace(s[0],'0'))