def decorateFruit(fruit, rotLevel):
    def outer_d_f(f):
        def d_f(*args, **kargs):
            print("%s %s before call" % (rotLevel, fruit))
            result = f(*args, **kargs)
            print("%s %s after call" % (rotLevel, fruit))
            return result

        return d_f

    return outer_d_f


@decorateFruit('banana', 'new')
def print_hello2():
    print("hello 2nd time.")


@decorateFruit('guava', '50% rot')
def print_hello3():
    print("hello 3th time.")


if __name__ == "__main__":
    print_hello2()
