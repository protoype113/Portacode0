counter=$(cat ./Default/count.txt)
count=$((counter + 1))
echo "$count" > ./Default/count.txt
git add .
git commit -m "codespace version $(cat ./Default/count.txt)"
git push origin main
