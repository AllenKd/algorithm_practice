
def connect_ropes(ropes):
    cost = 0
    while len(ropes) > 1:
        a = ropes.pop(ropes.index(min(ropes)))
        min_index = ropes.index(min(ropes))
        ropes[min_index] += a
        cost += ropes[min_index]
    return cost


# description: https://aonecode.com/amazon-online-assessment-oa2-connect-ropes
if __name__ == '__main__':
    print(connect_ropes([8, 4, 6, 12]))
    print(connect_ropes([20, 4, 8, 2]))
    print(connect_ropes([1, 2, 5, 10, 35, 89]))
