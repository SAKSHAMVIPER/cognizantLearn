while IFS= read -r line;
do
    if i=$(grep "Male" names.txt)
    then
        echo "$line" >> male_nominee.txt
    fi
    if j=$(grep "Female" names.txt)
    then
        echo "$line" >> female_nominee.txt
    fi
done < "names.txt"
ls
cat male_nominee.txt
cat female_nominee.txt