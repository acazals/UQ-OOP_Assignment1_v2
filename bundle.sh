#!/bin/bash

if [ -f submission.zip ]; then
  old=$(date +%s)
  echo "Backup up old submission as submission-${old}"
  echo
  mv submission.zip submission-"${old}".zip
fi

touch refs.md

zip submission.zip src/examblock/model/Desk.java
zip submission.zip src/examblock/model/Exam.java
zip submission.zip src/examblock/model/ExamList.java
zip submission.zip src/examblock/model/Room.java
zip submission.zip src/examblock/model/RoomList.java
zip submission.zip src/examblock/model/Session.java
zip submission.zip src/examblock/model/SessionList.java
zip submission.zip src/examblock/model/Student.java
zip submission.zip src/examblock/model/StudentList.java
zip submission.zip src/examblock/model/Subject.java
zip submission.zip src/examblock/model/SubjectList.java
zip submission.zip src/examblock/model/Unit.java
zip submission.zip src/examblock/model/UnitList.java
zip submission.zip src/examblock/model/Venue.java
zip submission.zip src/examblock/model/VenueList.java

#zip -r submission.zip test/*
zip submission.zip refs.md
