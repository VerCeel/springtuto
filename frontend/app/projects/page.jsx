import React from "react";
import ProjectTable from "@/components/ProjectTable";
import { Button } from "@/components/ui/button";
import Link from "next/link";

const page = () => {
  return (
    <div className="flex flex-col flex-1 items-center justify-center font-sans">
      <div className="flex flex-1 w-full max-w-3xl flex-col items-center justify-between py-32 px-16 sm:items-start">
        <div className="flex justify-between w-full mb-8">
          <h1 className="font-bold text-center sm:text-left">Projects</h1>
          <Link href="/" className="text-sm text-neutral-500">
            <Button className="mt-4" variant="outline">
              Students
            </Button>
          </Link>
        </div>
        <ProjectTable />
      </div>
    </div>
  );
};

export default page;
