{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf400
{\fonttbl\f0\froman\fcharset0 Times-Roman;\f1\fnil\fcharset0 LucidaGrande;}
{\colortbl;\red255\green255\blue255;\red26\green26\blue26;\red255\green255\blue255;\red26\green26\blue26;
}
{\*\expandedcolortbl;;\cssrgb\c13333\c13333\c13333;\cssrgb\c100000\c100000\c100000;\cssrgb\c13333\c13333\c13333;
}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc0\levelnfcn0\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{decimal\}.}{\leveltext\leveltemplateid1\'02\'00.;}{\levelnumbers\'01;}\fi-360\li720\lin720 }{\listname ;}\listid1}
{\list\listtemplateid2\listhybrid{\listlevel\levelnfc0\levelnfcn0\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{decimal\}.}{\leveltext\leveltemplateid101\'02\'00.;}{\levelnumbers\'01;}\fi-360\li720\lin720 }{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{hyphen\}}{\leveltext\leveltemplateid102\'01\uc0\u8259 ;}{\levelnumbers;}\fi-360\li1440\lin1440 }{\listname ;}\listid2}
{\list\listtemplateid3\listhybrid{\listlevel\levelnfc0\levelnfcn0\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{decimal\}.}{\leveltext\leveltemplateid201\'02\'00.;}{\levelnumbers\'01;}\fi-360\li720\lin720 }{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{hyphen\}}{\leveltext\leveltemplateid202\'01\uc0\u8259 ;}{\levelnumbers;}\fi-360\li1440\lin1440 }{\listname ;}\listid3}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}{\listoverride\listid2\listoverridecount0\ls2}{\listoverride\listid3\listoverridecount0\ls3}}
\paperw11900\paperh16840\margl1440\margr1440\vieww19260\viewh10200\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 This is solution for given N26 java assignment challenge.\
\
\pard\pardeftab720\sl560\partightenfactor0

\b \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Prerequisite
\b0 \
\pard\tx220\tx720\pardeftab720\li720\fi-720\sl560\partightenfactor0
\ls1\ilvl0\cf2 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	1.	}Preinstall Java8 \
{\listtext	2.	}Maven 3\
\pard\tx566\pardeftab720\sl560\partightenfactor0
\cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
How to build :\
\pard\tx566\pardeftab720\sl560\partightenfactor0
\cf2 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 	1.	Using Command line\
\pard\tx940\tx1440\pardeftab720\li1440\fi-1440\sl560\partightenfactor0
\ls2\ilvl1\cf2 {\listtext	
\f1 \uc0\u8259 
\f0 	}clone or download the project from\
\pard\tx940\tx1440\tx1700\pardeftab720\li1440\fi-1440\sl560\partightenfactor0
\ls2\ilvl1\cf2 {\listtext	
\f1 \uc0\u8259 
\f0 	}Go to project directory and run command \'93
\b mvn clean install
\b0 \'94\
\pard\tx220\tx720\tx1133\tx1700\pardeftab720\li720\fi-720\sl560\partightenfactor0
\ls2\ilvl0\cf2 {\listtext	2.	}Using IntelliJ\
\pard\tx940\tx1440\tx1700\pardeftab720\li1440\fi-1440\sl560\partightenfactor0
\ls2\ilvl1\cf2 {\listtext	
\f1 \uc0\u8259 
\f0 	}Go to the file menu\
{\listtext	
\f1 \uc0\u8259 
\f0 	}Click open option and brows cloned project folder and select pom file.\
{\listtext	
\f1 \uc0\u8259 
\f0 	}After that project open into IntelliJ\
\pard\tx566\tx1133\tx1700\pardeftab720\sl560\partightenfactor0
\cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
How to Run :\
\pard\tx220\tx720\tx1133\tx1700\pardeftab720\li720\fi-720\sl560\partightenfactor0
\ls3\ilvl0\cf2 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	1.	}Using \cf4 \cb3 Command line\
\pard\tx940\tx1440\tx1700\pardeftab720\li1440\fi-1440\sl560\partightenfactor0
\ls3\ilvl1\cf2 \cb3 {\listtext	
\f1 \uc0\u8259 
\f0 	}After build run following \'93
\b java -jar target/transaction-1.0-SNAPSHOT.jar
\b0 \'94\
\pard\tx220\tx720\tx1133\tx1700\pardeftab720\li720\fi-720\sl560\partightenfactor0
\ls3\ilvl0\cf2 {\listtext	2.	}Using IntelliJ\
\pard\tx940\tx1440\tx1700\pardeftab720\li1440\fi-1440\sl560\partightenfactor0
\ls3\ilvl1\cf2 {\listtext	
\f1 \uc0\u8259 
\f0 	}\cf4 \cb3 After open project into IDE open class Application.java and run main method  \cf2 \cb3 \
\pard\tx566\tx1133\tx1700\pardeftab720\sl560\partightenfactor0
\cf2 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
How to Use :\
\pard\tx940\tx1440\tx1700\pardeftab720\li1440\fi-1440\sl560\partightenfactor0
\cf4 \cb3 \kerning1\expnd0\expndtw0 \outl0\strokewidth0  open \'93{\field{\*\fldinst{HYPERLINK "http://localhost:8080/swagger-ui.html#/"}}{\fldrslt http://localhost:8080/swagger-ui.html#/}}\'94. So access all api using swagger. Apart from that also you can \
generate transaction using this shell script \'93
\b transcation_gen.sh
\b0 \'94. This shell script generate transaction every 5\
seconds.\cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
\
Note: Project build can take more than 60 second because in one test I am simulating 60 Second use case. For faster build use following command \'93
\b \cf4 \cb3 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 mvn clean install -DskipTests
\b0 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \'94. }