// 장르 별로 가장 많이 재생된 노래를 두개씩  -> 베스트 앨범
// 노래는 고유 번호로 구분
// 수록 기준 
// 1. 속한 노래가 많이 재생된 장르를 먼저 수록
// 2. 장르 내에서 많이 재생된 노래를 먼저 수록
// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
// plays: 노래별 재생 횟수
// return: 베스트 앨범에 들어갈 고유 번호를 순서대로
import java.util.*;
import java.util.stream.Stream;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();
        
        for (int i=0;i<genres.length;i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        Stream<Map.Entry<String, Integer>> sortedGenre = 
            playMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = 
                genreMap.get(entry.getKey()).stream().sorted((o1, o2) -> Integer.compare(o2[1], o1[1])).limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}