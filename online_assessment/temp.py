def topNCompetitors(numCompetitors, topNCompetitors, competitors,
                    numReviews, reviews):
    # WRITE YOUR CODE HERE
    count = {}
    for r in reviews:
        for c in competitors:
            if c in count:
                count[c] += r.count(c)
            else:
                count[c] = r.count(c)

    return sorted(sorted(list(count.keys()), key=lambda x: count[x])[:topNCompetitors])

if __name__ == '__main__':
    print(topNCompetitors(5, 2, ['a', 'b', 'c', 'd', 'e'], 3, [' a ', 'b ', 'a ']))