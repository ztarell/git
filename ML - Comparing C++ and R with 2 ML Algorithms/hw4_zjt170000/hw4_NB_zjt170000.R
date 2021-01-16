# Homework 4 - Zachary Tarell
# Naive Bayes model on titanic csv file data

df <- read.csv("C:/Users/ztare/Machine Learning/titanic_project.csv", header=TRUE)
#data cleaning
start <- proc.time()
df$pclass <- factor(df$pclass)
df$survived <- factor(df$survived)

# handle missing values
df <- df[!is.na(df$pclass),]
df <- df[!is.na(df$survived),]

#setting train and test
train <- df[1:900,]
test <- df[901:1046,]

#creating naive bayes model
library(e1071)
nb1 <- naiveBayes(survived~pclass+age+sex, data = train)
nb1


p1 <- predict(nb1,newdata = test, type = "class")
table (p1, test$survived)
mean (p1==test$survived)

p1_raw <- predict(nb1,newdata = test, type = "raw")
head(p1_raw)

library(caret)
#displays info acc/sensitivity/specificity
confusionMatrix(p1,test$survived, positive = "1")

# Total time
end <- proc.time()
totaltime <- end-start
print(paste("Total time spent:", totaltime))

# Plots
cdplot(df$survived~df$pclass)
cdplot(df$survived~df$sex)

# Data Exploration to equal 4 total
names(nb1)
summary(nb1)