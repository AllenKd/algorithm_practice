class Solution:
    def sol(self, nums):

        N = len(nums)
        M = len(nums[0])

        nums[0][0] = 1e9
        nums[N - 1][M - 1] = 1e9

        dp = [[1e9] * M for i in range(N)]

        for j in range(1, M):
            dp[0][j] = min(dp[0][j - 1], nums[0][j])
        for i in range(1, N):
            dp[i][0] = min(dp[i - 1][0], nums[i][0])

        for i in range(1, N):
            for j in range(1, M):
                cur = max(dp[i - 1][j], dp[i][j - 1])
                dp[i][j] = min(cur, nums[i][j])
        # print(dp)

        print("ans: " + str(dp[N - 1][M - 1]))

    def my_sol(self, arr):
        col = len(arr)
        row = len(arr[0])

        track = [[1e9] * row for _ in range(col)]
        # count the minimum of 1st row and 1st col by work
        for i in range(1, col):
            track[0][i] = min(track[0][i-1], track[0][i])

        for i in range(1, row):
            track[i][0] = min(track[i-1][0], track[i][0])

        for i in range(row):
            for j in range(col):
                # get up and left value of current position
                c = max(track[i-1][j], track[i][j-1])

                # set target value to min of current and original arr
                track[i][j] = min(c, arr[i][j])
        return track[col][row]



if __name__ == '__main__':
    case = [[7, 5, 3],
            [2, 0, 9],
            [4, 5, 9]]
    Solution().sol(case)
