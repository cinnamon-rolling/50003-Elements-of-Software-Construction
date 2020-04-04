from random import randint


def swap(content):
    len_content = len(content)
    first_char = randint(0, len_content-1)
    second_char = randint(0, len_content-1)

    ls_content = list(content)

    ls_content[first_char], ls_content[second_char] = ls_content[second_char], ls_content[first_char]
    content_out = ''.join(ls_content)
    print(
        f'swapping between index {first_char} and {second_char} with values of {content[first_char]} and {content[second_char]} respectively')
    print(content_out)
    return content_out


def bit_flip(content):
    len_content = len(content)
    number_of_char = randint(1, len_content)

    ls_swap = []
    ls_content = list(content)

    for i in range(number_of_char):
        ls_swap.append(randint(0, len_content-1))

    ls_swap = list(dict.fromkeys(ls_swap))  # remove duplicated indexes

    # change 0 to 1 or 1 to 0
    for i in ls_swap:
        if ls_content[i] == "0":
            ls_content[i] = "1"
        else:
            ls_content[i] = "0"

    content_out = ''.join(ls_content)
    print(
        f'bit flipping {len(ls_swap)} in file, which are in the index of {ls_swap}')
    print(content_out)
    return content_out


def trim(content):
    len_content = len(content)
    number_of_char = randint(1, len_content)

    ls_trim = []
    ls_content = list(content)

    for i in range(number_of_char):
        ls_trim.append(randint(0, len_content-1))

    ls_trim = list(dict.fromkeys(ls_trim))  # remove duplicated indexes

    for i in ls_trim:
        ls_content[i] = ""

    content_out = ''.join(ls_content)
    print(f'trimming bits at index of {ls_trim}')
    print(content_out)
    return content_out


if __name__ == "__main__":
    file = "./test_input.txt"

    opened_file = open(file, "r+")
    content = opened_file.read()
    print(content)
    picker = randint(0, 2)

    # open new file
    out_file = open("./out_file.txt", "w")

    # pick which operation
    if picker == 0:
        print('operating swap')
        # write to output file
        out_file.writelines(swap(content))

    elif picker == 1:
        print('operating bit flip')
        # write to output file
        out_file.writelines(bit_flip(content))

    else:
        print('operating trim')
        # write to output file
        out_file.writelines(trim(content))

    opened_file.close()
    out_file.close()
