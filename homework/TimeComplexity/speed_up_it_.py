# Існує популярний веб-сервер задача якого прибирати зайві символи "/".
# Наприклад, рядок "/page1///page2////page3/test.html" має стиснутись до "/page1/page2/page3/test.html"
# На жаль, оригінальний алгоритм має квадратичну складність, 
# чим можуть скористатись хакери відправивши одночасно ряд запитів з великою кількістью символів "/".
# Вас запросили як спеціаліста з алгоритмів для усунення потенційної небезпеки. Пришвидшіть оригінальний алгоритм, аби він працював за лінію.

# python3

def newNoTwoSlash(url: str):
    compact_url = '' if len(url) == 0 else url[0]

    for i in range(1, len(url)):
        if (url[i] == '/') and (url[i-1] == '/'):
            i += 1
        else:
            compact_url += url[i]
    return compact_url



def noTwoSlash(url: str):
    _list = list(url)
    i = 1
    while i < len(_list):
        if (_list[i-1] == '/') and (_list[i] == '/'):
            for y in range(i+1, len(_list)):
                _list[y-1] = _list[y]
            _list = _list[:-1]
        else:
            i += 1
    return ''.join(_list)


def main():
    print(newNoTwoSlash(""))
    print(newNoTwoSlash("/page1///page2////page3/test.html"))
    print(newNoTwoSlash("//page1///page2////page3/test.html"))
    print(newNoTwoSlash("///page1///page2////page3/test.html"))
    print(newNoTwoSlash("///page1///page2////page3/test.html//"))

if __name__ == '__main__':
    main()