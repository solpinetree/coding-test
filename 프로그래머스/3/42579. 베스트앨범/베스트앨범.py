# 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 함.
# 노래 장르를 나타내는 문자열 배열 genres
# 노래별 재생 횟수를 나타내는 정수 배열 plays
# 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
from collections import defaultdict

def solution(genres, plays):
    
    genre_play_dict = defaultdict(int)
    genre_song_dict = defaultdict(list)
    
    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_play_dict[genre] += play
        genre_song_dict[genre].append((play, i))
        
    genre_sorted = sorted(genre_play_dict.keys(), key = lambda g: genre_play_dict[g], reverse=True)
    
    answer = []
    
    for genre in genre_sorted:
        songs = sorted(genre_song_dict[genre], key = lambda x : (-x[0], x[1]))
        # 최대 2개의 노래 선택
        answer.extend([idx for play, idx in songs[:2]])
        
    return answer