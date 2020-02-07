def movies_on_flight(movie_durations, flight_duration):
    flight_duration -= 30
    movie_durations.sort()
    l = 0
    r = len(movie_durations) - 1
    sum = 0
    m1, m2 = None, None
    while l < r:
        if movie_durations[l] + movie_durations[r] < flight_duration:
            if sum < movie_durations[l] + movie_durations[r]:
                sum = movie_durations[l] + movie_durations[r]
                m1 = l
                m2 = r
            l += 1
        else:
            r -= 1
    return [movie_durations[m1], movie_durations[m2]]


# description: https://aonecode.com/amazon-online-assessment-questions#m
if __name__ == '__main__':
    print(movies_on_flight([90, 85, 75, 60, 120, 150, 125], 250))