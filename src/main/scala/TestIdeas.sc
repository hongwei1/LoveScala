var capital =Map("US"->"Washington","France"->"Paries")
capital += ("Japan"-> "Tokeyo")
println(capital("France"))

def factoial (x:BigInt):BigInt =
  if(x==0) 1 else x*factoial( x -1)

factoial(30)
