def decor_my_decorator(decor_param):
    def my_decorator(func):
        def wrapper():
            print(f"before exec")
            print(decor_param)
            func()
            print(f"after exec")

        return wrapper

    return my_decorator


@decor_my_decorator("decro params")
def to_be_decorate_func():
    print(f"the function to be decorate")


if __name__ == "__main__":
    # to_be_decorate_func = my_decorator(to_be_decorate_func)
    to_be_decorate_func()
