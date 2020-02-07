def calculate_span(price):
    s = [1]

    for i in range(1, len(price)):
        s.append(1)

        j = i - 1
        while j >= 0 and price[i] >= price[j]:
            s[-1] += 1
            j -= 1
    return s


def calculate_span_constant_time(price):
    n = len(price)
    st = [0]
    s = [1]

    for i in range(1, n):
        while len(st) and price[st[-1]] <= price[i]:
            st.pop()
        s.append(i + 1 if not len(st) else i - st[-1])
        st.append(i)


# description: https://www.geeksforgeeks.org/the-stock-span-problem/
if __name__ == '__main__':
    price = [10, 4, 5, 90, 120, 80]
    print(calculate_span(price))
    print(calculate_span_constant_time(price))
