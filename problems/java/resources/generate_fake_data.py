# -*- coding: utf-8 -*-
"""
    fake data generation script
    ~~~~~~~~
    :copyright: (c) 2013 chez FIFTYFIVE by basilboli
    prohibited by real patsan's law.

    to run execute : 
    python generate_fake_data.py > filename.csv
"""

import random,string
def main():
    for i in xrange(1000000):
        print int(random.uniform(1, 1000000))

if __name__ == "__main__":
    main()