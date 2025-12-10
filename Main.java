class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
    String file = Input.readFile("test.txt");

    // Encode
    String level1 = level1Encode(file);
    print("Level 1: " + level1);
    String level2 = level2Encode(file);
    print("Level 2: " + level2);
    String level3 = level3Encode(file);
    print("Level 3: " + level3);

    // Decode
    print("Decoded level 1: " + level1Decode(level1));
    print("Decoded level 2: " + level2Decode(level2));
    print("Decoded level 3: " + level3Decode(level3));
  }

// Level 1 ecode
String level1Encode(String txt){
    String bld="";
    for(int i=0;i<txt.length();i+=2){
      bld += txt.charAt(i);
    }
    for(int i=1;i<txt.length();i+=2){
      bld += txt.charAt(i);
    }
    return bld;
}

// Level 1 decode
String level1Decode(String txt){
    int n = txt.length();
    int evensCount = (n+1)/2; 
    String evens = txt.substring(0, evensCount);
    String odds = txt.substring(evensCount);
    String bld="";
    for(int i=0;i<evensCount;i++){
      bld += evens.charAt(i);
      if(i<odds.length()){
        bld += odds.charAt(i);
      }
    }
    return bld;
}

  // Level 2 encode
  String level2Encode(String txt){
    String bld="";
    int n = txt.length();
    for(int i=0;i<n;i++){
      char c = txt.charAt(i);
      int val = (int)c;
      if(i%2==0){
        val -= n;
      } else {
        val += n;
      }
      bld += (char)val;
    }
    return bld;
  }

  // Level 2 decode
  String level2Decode(String txt){
    String bld="";
    int n = txt.length();
    for(int i=0;i<n;i++){
      char c = txt.charAt(i);
      int val = (int)c;
      if(i%2==0){
        val += n;
      } else {
        val -= n;
      }
      bld += (char)val;
    }
    return bld;
  }

  // Level 3 encode
  String level3Encode(String txt){
    String bld="";
    int n = txt.length();
    int[] coeff = pascalRow(n);
    for(int i=0;i<n;i++){
      char c = txt.charAt(i);
      int val = (int)c + coeff[i+1];
      bld += (char)val;
    }
    return bld;
  }

  // Level 3 decode
  String level3Decode(String txt){
    String bld="";
    int n = txt.length();
    int[] coeff = pascalRow(n);
    for(int i=0;i<n;i++){
      char c = txt.charAt(i);
      int val = (int)c - coeff[i+1];
      bld += (char)val;
    }
    return bld;
  }

  // Generate Pascal row
  int[] pascalRow(int n){
    int[] row = new int[n+1];
    row[0]=1;
    for(int i=1;i<=n;i++){
      row[i] = (int)(row[i-1]*(n-i+1)/i);
    }
    return row;
  }
}
