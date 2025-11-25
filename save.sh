counter=$(cat count.txt)
count=$((counter + 1))
echo "$count" > count.txt
git add .
git commit -m "codespace version $(cat count.txt)"
git push origin main
