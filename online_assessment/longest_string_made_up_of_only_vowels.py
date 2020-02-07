def longestVowelsOnlySubstring(S):
    temp, aux, vowels = 0, [], set('aeiou')
    # Count the length of each vowel substring
    for c in S + 'z':
        if c in vowels:
            temp += 1
        elif temp:
            aux.append(temp)
            temp = 0
    # If the first letter is not vowel, you must cut the head
    if S[0] not in vowels: aux = [0] + aux
    # If the last letter is not vowel, you must cut the tail
    if S[-1] not in vowels: aux += [0]
    # Max length = max head + max tail + max middle
    return aux[0] + aux[-1] + max(aux[1:-1]) if len(aux) >= 3 else sum(aux)


if __name__ == '__main__':
    print(longestVowelsOnlySubstring('earthproblem'))
    print(longestVowelsOnlySubstring('letsgosomewhere'))