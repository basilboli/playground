# Problem 

When using rm -R on crowded directories you probably had the following error  `/bin/rm: Argument list too long`.

fastrm is a replacement for unix rm command for those cases.

# How to run

go build

./fastrm -pattern "/tmp/*"

