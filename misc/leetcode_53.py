from typing import List


def maxSubArray(nums: List[int]) -> int:
    for i in range(1, len(nums)):
        if nums[i - 1] > 0:
            nums[i] += nums[i - 1]
    return max(nums)


if __name__ == "__main__":
    maxSubArray([-1, 2, -1, 3, -2])
