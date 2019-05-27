<?php
	
	$student = $POST[studentID];
	$gpa = $POST[GPA];
	$faculty = $POST[faculty];
	$acad = $POST[academicLevel];
	$schol = $POST[scholarship];
	
	mysql_connect("localhost", "root", "");
	mysql_select_db("students");
	
?>