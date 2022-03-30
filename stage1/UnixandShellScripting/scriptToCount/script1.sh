#!/bin/bash
echo "Number of characters in $1 is `wc -m < $1`"
echo "Number of words in $1 is `wc -w < $1`"
echo "Number of lines in $1 is `wc -l < $1`"