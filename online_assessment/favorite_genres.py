def favorite_genres(user_map, genre_map):
    resp = {user: [] for user in user_map}

    for user, user_songs in user_map.items():
        score = {}
        for user_song in user_songs:
            for genre, genre_song in genre_map.items():
                if user_song in genre_song:
                    if genre in score:
                        score[genre] += 1
                    else:
                        score[genre] = 1
                    break
        resp[user] = sorted(list(score.keys()), key=lambda x: score[x], reverse=True)

    return resp


# description: https://aonecode.com/amazon-online-assessment-questions#g
if __name__ == '__main__':
    userMap = {
        "David": ["song1", "song2", "song3", "song4", "song8"],
        "Emma": ["song5", "song6", "song7"]
    }
    genreMap = {
        "Rock": ["song1", "song3"],
        "Dubstep": ["song7"],
        "Techno": ["song2", "song4"],
        "Pop": ["song5", "song6"],
        "Jazz": ["song8", "song9"]
    }
    print(favorite_genres(userMap, genreMap))