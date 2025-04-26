class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 모든 길이 배열로 만들기
        String[] temp = video_len.split(":");
        int[] video_len_arr = new int[2];
        video_len_arr[0] = Integer.parseInt(temp[0]);
        video_len_arr[1] = Integer.parseInt(temp[1]);
        
        temp = pos.split(":");
        int[] pos_arr = new int[2];
        pos_arr[0] = Integer.parseInt(temp[0]);
        pos_arr[1] = Integer.parseInt(temp[1]);
        
        temp = op_start.split(":");
        int[] op_start_arr = new int[2];
        op_start_arr[0] = Integer.parseInt(temp[0]);
        op_start_arr[1] = Integer.parseInt(temp[1]);
        
        temp = op_end.split(":");
        int[] op_end_arr = new int[2];
        op_end_arr[0] = Integer.parseInt(temp[0]);
        op_end_arr[1] = Integer.parseInt(temp[1]);
        
        // 명령어들 실행
        int commands_len = commands.length;
        for (int i = 0; i < commands_len; i++) {
            // 1. 오프닝 구간일 경우 오프닝 종료 구간으로 건너뛰기
            if (skip_opening(op_start_arr, op_end_arr, pos_arr)) {
                pos_arr[0] = op_end_arr[0];
                pos_arr[1] = op_end_arr[1];
            }
            
            // 2. 명령어 적용
            String command = commands[i];
            if (command.equals("prev")) {
                pos_arr[1] -= 10;
            } else {
                pos_arr[1] += 10;
            }
            
            // 3. 60초 시계열에 따른 조정
            if (pos_arr[1] >= 60) {
                pos_arr[0] += 1;
                pos_arr[1] -= 60;
            } else if (pos_arr[1] < 0) {
                pos_arr[0] -= 1;
                pos_arr[1] += 60;
            }
            
            // 4. 동영상의 길이 초과 혹은 마이너스 길이 조정
            if (video_len_arr[0] < pos_arr[0]) {
                pos_arr[0] = video_len_arr[0];
                pos_arr[1] = video_len_arr[1];
            } else if (video_len_arr[0] == pos_arr[0] && video_len_arr[1] < pos_arr[1]) {
                pos_arr[1] = video_len_arr[1];
            }
            
            if (pos_arr[0] < 0) {
                pos_arr[0] = 0;
                pos_arr[1] = 0;
            } else if (pos_arr[0] == 0 && pos_arr[1] < 0) {
                pos_arr[1] = 0;
            }
        }
        
        if (skip_opening(op_start_arr, op_end_arr, pos_arr)) {
            pos_arr[0] = op_end_arr[0];
            pos_arr[1] = op_end_arr[1];
        }
        
        String min = "";
        String sec = "";
        
        if (pos_arr[0] < 10) {
            min = "0" + pos_arr[0];
        } else {
            min = "" + pos_arr[0];
        }
        
        if (pos_arr[1] < 10) {
            sec = "0" + pos_arr[1];
        } else {
            sec = "" + pos_arr[1];
        }
        
        return min + ":" + sec;
    }
    
    public static boolean skip_opening(int[] op_start_arr, int[] op_end_arr, int[] pos_arr) {
        if (op_start_arr[0] < pos_arr[0] && pos_arr[0] < op_end_arr[0]) {
            return true;
        } else if (op_start_arr[0] == pos_arr[0] && pos_arr[0] < op_end_arr[0]) {
            if (op_start_arr[1] <= pos_arr[1]) {
                return true;
            } else {
                return false;
            }
        } else if (op_start_arr[0] < pos_arr[0] && pos_arr[0] == op_end_arr[0]) {
            if (pos_arr[1] < op_end_arr[1]) {
                return true;
            } else {
                return false;
            }
        } else if (op_start_arr[0] == pos_arr[0] && pos_arr[0] == op_end_arr[0]) {
            if (op_start_arr[1] <= pos_arr[1] && pos_arr[1] < op_end_arr[1]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}