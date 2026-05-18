import React from "react";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

const ProjectTable = () => {
  return (
    <div className="w-full">
      <Table>
        <TableCaption>A List of Students</TableCaption>
        <TableHeader>
          <TableRow >
            <TableHead className="w-[100px] ">Name</TableHead>
            <TableHead>Age</TableHead>
            <TableHead>Grade</TableHead>
            <TableHead className="text-right">Amount</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          <TableRow>
            <TableCell className="font-medium">John Doe</TableCell>
            <TableCell>20</TableCell>
            <TableCell>A</TableCell>
            <TableCell className="text-right">$250.00</TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </div>
  );
};

export default ProjectTable;
