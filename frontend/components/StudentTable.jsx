"use client";

import React from "react";
import { MoreHorizontalIcon } from "lucide-react"
import { Button } from "@/components/ui/button"
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"

import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { useEffect, useState } from "react";

const StudentTable = () => {
  const [students, setStudents] = useState([]);


    const fetchStudents = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/students");
      const data = await response.json();
      setStudents(data);
    } catch (error) {
      console.error("Error fetching students:", error);
    }
  };

  const handleDelete = async (studentId) => {
    try {
      await fetch(`http://localhost:8080/api/students/${studentId}`, {
        method: "DELETE",
      });
      fetchStudents();
    } catch (error) {
      console.error("Error deleting student:", error);
    }
  };


  useEffect(() => {
    fetchStudents();
  }, []);

  return (
    <div className="w-full">
      <Table>
        <TableCaption>A List of Students</TableCaption>
        <TableHeader>
          <TableRow>
            <TableHead className="">Full Name</TableHead>
            <TableHead>Age</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {students.map((student) => (
            <TableRow key={student.id}>
              <TableCell className="font-medium">
                {student.firstName} {student.lastName}
              </TableCell>
              <TableCell>{student.age}</TableCell>
              <TableCell className="text-right">
                <DropdownMenu>
                  <DropdownMenuTrigger asChild>
                    <Button variant="ghost" size="icon" className="size-8">
                      <MoreHorizontalIcon />
                      <span className="sr-only">Open menu</span>
                    </Button>
                  </DropdownMenuTrigger>
                  <DropdownMenuContent align="end">
                    <DropdownMenuItem>Projects</DropdownMenuItem>
                    <DropdownMenuItem >
                      Edit
                    </DropdownMenuItem>
                    <DropdownMenuSeparator />
                    <DropdownMenuItem variant="destructive" onClick={() => handleDelete(student.id)}>
                      Delete
                    </DropdownMenuItem>
                  </DropdownMenuContent>
                </DropdownMenu>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
};

export default StudentTable;
