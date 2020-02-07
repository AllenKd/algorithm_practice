def roll_dice(dices):
    move = 2 * len(dices)
    for i in range(1, 7):
        move = min(move, sum([2 if d + i == 7 else 0 if d == i else 1 for d in dices]))
    return move


# description: https://aonecode.com/amazon-online-assessment-questions#dl
if __name__ == '__main__':
    print(roll_dice([1, 2, 3]))
    print(roll_dice([1, 1, 6]))
    print(roll_dice([1, 6, 2, 3]))
