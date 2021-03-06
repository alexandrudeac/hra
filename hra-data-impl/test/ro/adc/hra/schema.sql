-- Generated by Oracle SQL Developer Data Modeler 4.0.3.853
--   at:        2015-04-12 21:53:59 EEST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g




CREATE TABLE ABSENCE_PARAM
  (
    ABSENCE_PARAM_ID NUMBER NOT NULL ,
    ABSENCE_TYPE_ID  NUMBER NOT NULL ,
    CONSECUTIVE_DAYS NUMBER (3) ,
    DAYS_PER_YEAR    NUMBER (3) ,
    SHEET_ID         NUMBER NOT NULL
  ) ;
ALTER TABLE ABSENCE_PARAM ADD CONSTRAINT PK_ABSENCE_PARAM PRIMARY KEY ( ABSENCE_PARAM_ID ) ;
ALTER TABLE ABSENCE_PARAM ADD CONSTRAINT UN_ABSENCE_PRM_SHEET_ABS_TYPE UNIQUE ( ABSENCE_TYPE_ID , SHEET_ID ) ;

CREATE TABLE ABSENCE_PARAM_SHEET
  (
    ABSENCE_PARAM_SHEET_ID NUMBER CONSTRAINT NN_ABS_PRM_SHEET_ID NOT NULL ,
    CODE                   VARCHAR2 (30 CHAR) ,
    NAME                   VARCHAR2 (100 CHAR) ,
    PARENT_ID              NUMBER CONSTRAINT NN_ABS_PRM_SHEET_PARENT_ID NOT NULL
  ) ;
ALTER TABLE ABSENCE_PARAM_SHEET ADD CONSTRAINT PK_ABSENCE_PARAM_SHEET PRIMARY KEY ( ABSENCE_PARAM_SHEET_ID ) ;

CREATE TABLE ABSENCE_PERIOD
  (
    ABSENCE_PERIOD_ID NUMBER CONSTRAINT NN_ABSENCE_PERIOD_ABS_PRD_ID NOT NULL ,
    EMPLOYEE_ID       NUMBER CONSTRAINT NN_ABSENCE_PERIOD_EMPLOYEE_ID NOT NULL ,
    ABSENCE_TYPE_ID   NUMBER CONSTRAINT NN_ABSENCE_PERIOD_ABS_TYP_ID NOT NULL ,
    START_DATE        DATE CONSTRAINT NN_ABSENCE_PERIOD_START_DT NOT NULL ,
    END_DATE          DATE CONSTRAINT NN_ABSENCE_PERIOD_END_DT NOT NULL ,
    ALL_DAY           CHAR (1) DEFAULT '1' NOT NULL ,
    DURATION          INTEGER ,
    STATE             CHAR (30 BYTE) NOT NULL
  ) ;
ALTER TABLE ABSENCE_PERIOD ADD CONSTRAINT CK_ABSENCE_PERIOD_ALL_DAY CHECK ( (ALL_DAY = '0') OR (ALL_DAY = '1' AND DURATION IS NOT NULL)) ;
ALTER TABLE ABSENCE_PERIOD ADD CONSTRAINT PK_ABSENCE_PERIOD PRIMARY KEY ( ABSENCE_PERIOD_ID ) ;

CREATE TABLE ABSENCE_TYPE
  (
    ABSENCE_TYPE_ID NUMBER CONSTRAINT NN_ABSENCE_TYPE_ABS_TYP_ID NOT NULL ,
    CODE            VARCHAR2 (30 CHAR) CONSTRAINT NN_ABSENCE_TYPE_CODE NOT NULL ,
    NAME            VARCHAR2 (200) CONSTRAINT NN_ABSENCE_TYPE_NAME NOT NULL ,
    ROLLOVER        CHAR (1) DEFAULT '0' NOT NULL ,
    ACTIVE          CHAR (1) DEFAULT '1' CONSTRAINT NN_ABSENCE_TYPE_ACTIVE NOT NULL
  ) ;
ALTER TABLE ABSENCE_TYPE ADD CONSTRAINT PK_ABSENCE_TYPE PRIMARY KEY ( ABSENCE_TYPE_ID ) ;
ALTER TABLE ABSENCE_TYPE ADD CONSTRAINT UN_ABSENCE_TYPE_CODE UNIQUE ( CODE ) ;
ALTER TABLE ABSENCE_TYPE ADD CONSTRAINT UN_ABSENCE_TYPE_NAME UNIQUE ( NAME ) ;

CREATE TABLE EMPLOYEE
  (
    EMPLOYEEID          NUMBER CONSTRAINT NN_EMPLOYEE_EMPLOYEEID NOT NULL ,
    EMPLOYEEUUID        VARCHAR2 (36 BYTE) CONSTRAINT NN_EMPLOYEE_EMPLOYEEUUID NOT NULL ,
    CODE                VARCHAR2 (30 CHAR) CONSTRAINT NN_EMPLOYEE_CODE NOT NULL ,
    LASTNAME            VARCHAR2 (100 CHAR) CONSTRAINT NN_EMPLOYEE_LASTNAME NOT NULL ,
    FIRSTNAME           VARCHAR2 (100 CHAR) CONSTRAINT NN_EMPLOYEE_FIRSTNAME NOT NULL ,
    MIDDLENAME          VARCHAR2 (100 CHAR) ,
    ACTIVE              CHAR (1) DEFAULT '1' CONSTRAINT NN_EMPLOYEE_ACTIVE NOT NULL ,
    VERSTATUS           CHAR (1 BYTE) DEFAULT 'C' CONSTRAINT NN_EMPLOYEE_VERSTATUS NOT NULL ,
    VERNO               NUMBER DEFAULT 1 CONSTRAINT NN_EMPLOYEE_VERNO NOT NULL ,
    SINCEMODIFICATIONID NUMBER CONSTRAINT NN_EMPLOYEE_SMODIFID NOT NULL ,
    UNTILMODIFICATIONID NUMBER
  ) ;
CREATE INDEX IX_EMPLOYEE_VERSTATUS ON EMPLOYEE
  ( VERSTATUS ASC
  ) ;
CREATE INDEX IX_EMPLOYEE_EMPLOYEEUUID ON EMPLOYEE
  ( EMPLOYEEUUID ASC
  ) ;
CREATE INDEX IX_EMPLOYEE_CODE ON EMPLOYEE
  ( CODE ASC
  ) ;
ALTER TABLE EMPLOYEE ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY ( EMPLOYEEID ) ;
ALTER TABLE EMPLOYEE ADD CONSTRAINT UN_EMPLOYEE_CODE UNIQUE ( CODE , UNTILMODIFICATIONID ) ;
ALTER TABLE EMPLOYEE ADD CONSTRAINT UN_EMPLOYEE_FULLNAME UNIQUE ( LASTNAME , FIRSTNAME , MIDDLENAME , UNTILMODIFICATIONID ) ;
ALTER TABLE EMPLOYEE ADD CONSTRAINT UN_EMPLOYEE_EMPLOYEEUUID UNIQUE ( EMPLOYEEUUID , UNTILMODIFICATIONID ) ;

CREATE TABLE EMPLOYEE_TIMETABLE
  (
    EMPLOYEE_TIMETABLE_ID NUMBER CONSTRAINT NN_EMPL_TMTBL_ID NOT NULL ,
    EMPLOYEE_ID           NUMBER CONSTRAINT NN_EMPL_TMTBL_EMPLOYEE_ID NOT NULL ,
    TIMETABLE_ID          NUMBER CONSTRAINT NN_EMPL_TMTBL_TIMETABLE_ID NOT NULL ,
    VALID_FROM            DATE CONSTRAINT NN_EMPL_TMTBL_VALID_FROM NOT NULL ,
    VALID_UNTIL           DATE CONSTRAINT NN_EMPL_TMTBL_VALID_UNTIL NOT NULL
  ) ;
ALTER TABLE EMPLOYEE_TIMETABLE ADD CONSTRAINT CK_EMPL_TMTBL_VALID_PERIOD CHECK (VALID_FROM<=VALID_UNTIL) ;
ALTER TABLE EMPLOYEE_TIMETABLE ADD CONSTRAINT PK_EMPLOYEE_TIMETABLE PRIMARY KEY ( EMPLOYEE_TIMETABLE_ID ) ;
ALTER TABLE EMPLOYEE_TIMETABLE ADD CONSTRAINT UN_EMPL_TMTBL_VALID_FROM UNIQUE ( EMPLOYEE_ID , TIMETABLE_ID , VALID_FROM ) ;
ALTER TABLE EMPLOYEE_TIMETABLE ADD CONSTRAINT UN_EMPL_TMTBL_VALID_UNTIL UNIQUE ( EMPLOYEE_ID , TIMETABLE_ID , VALID_UNTIL ) ;

CREATE TABLE EMPL_ABS_PRM_SHEET
  (
    EMPL_ABS_PRM_SHEET_ID NUMBER CONSTRAINT NN_EMPL_ABS_PRM_SHEET_ID NOT NULL ,
    EMPLOYEE_ID           NUMBER CONSTRAINT NN_EMPL_ABS_PRM_SHEET_EMPL_ID NOT NULL ,
    ABS_PRM_SHEET_ID      NUMBER CONSTRAINT NN_EMPL_ABS_PRM_SHEET_SHEET_ID NOT NULL ,
    VALID_FROM            DATE CONSTRAINT NN_EMPL_ABS_PRM_SHEET_VLD_FR NOT NULL ,
    VALID_UNTIL           DATE CONSTRAINT NN_EMPL_ABS_PRM_SHEET_VLD_UN NOT NULL
  ) ;
ALTER TABLE EMPL_ABS_PRM_SHEET ADD CONSTRAINT PK_EMPL_ABS_PRM_SHEET PRIMARY KEY ( EMPL_ABS_PRM_SHEET_ID ) ;
ALTER TABLE EMPL_ABS_PRM_SHEET ADD CONSTRAINT UN_EMPL_ABS_PRM_SHT_EM_SHT_V_F UNIQUE ( EMPLOYEE_ID , ABS_PRM_SHEET_ID , VALID_FROM ) ;
ALTER TABLE EMPL_ABS_PRM_SHEET ADD CONSTRAINT UN_EMPL_ABS_PRM_SHT_EM_SHT_V_U UNIQUE ( EMPLOYEE_ID , ABS_PRM_SHEET_ID , VALID_UNTIL ) ;

CREATE TABLE MODIFICATION
  (
    MODIFICATIONID NUMBER NOT NULL ,
    MODIFDATETIME  DATE NOT NULL ,
    OPERATOR       VARCHAR2 (50 BYTE) NOT NULL
  ) ;
CREATE INDEX IX_MODIF_MODIFDATETIME ON MODIFICATION
  ( MODIFDATETIME ASC
  ) ;
CREATE INDEX IX_MODIF_OPERATOR ON MODIFICATION
  ( OPERATOR ASC
  ) ;
ALTER TABLE MODIFICATION ADD CONSTRAINT PK_MODIFICATION PRIMARY KEY ( MODIFICATIONID ) ;

CREATE TABLE TIMETABLE
  (
    TIMETABLE_ID NUMBER CONSTRAINT NN_TIMETABLE_TIMETABLE_ID NOT NULL ,
    CODE         VARCHAR2 (30 CHAR) CONSTRAINT NN_TIMETABLE_CODE NOT NULL ,
    NAME         VARCHAR2 (100 CHAR) CONSTRAINT NN_TIMETABLE_NAME NOT NULL ,
    ACTIVE       CHAR (1) DEFAULT '1' CONSTRAINT NN_TIMETABLE_ACTIVE NOT NULL
  ) ;
ALTER TABLE TIMETABLE ADD CONSTRAINT PK_TIMETABLE PRIMARY KEY ( TIMETABLE_ID ) ;

CREATE TABLE TIMETABLE_DAY
  (
    TIMETABLE_DAY_ID NUMBER CONSTRAINT NN_TIMETABLE_DAY_TMTBL_DAY_ID NOT NULL ,
    TIMETABLE_ID     NUMBER CONSTRAINT NN_TIMETABLE_DAY_TIMETABLE_ID NOT NULL ,
    DAY_INDEX        INTEGER NOT NULL ,
    OPENED           CHAR (1) DEFAULT '1' CONSTRAINT NN_TIMETABLE_DAY_OPENED NOT NULL ,
    WORK_DURATION    NUMBER (4)
  ) ;
ALTER TABLE TIMETABLE_DAY ADD CONSTRAINT CK_TMTBL_TMPL_OPENED_WORK_DUR CHECK ( (OPENED = '0') OR (OPENED = '1' AND WORK_DURATION IS NOT NULL)) ;
ALTER TABLE TIMETABLE_DAY ADD CONSTRAINT PK_TIMETABLE_DAY PRIMARY KEY ( TIMETABLE_DAY_ID ) ;
ALTER TABLE TIMETABLE_DAY ADD CONSTRAINT UN_TIMETABLE_DAY_ UNIQUE ( TIMETABLE_ID , DAY_INDEX ) ;

ALTER TABLE ABSENCE_PARAM ADD CONSTRAINT FK_ABSENCE_PARAM_ABSENCE_TYPE FOREIGN KEY ( ABSENCE_TYPE_ID ) REFERENCES ABSENCE_TYPE ( ABSENCE_TYPE_ID ) ;

ALTER TABLE ABSENCE_PARAM ADD CONSTRAINT FK_ABSENCE_PARAM_ABS_PRM_SHEET FOREIGN KEY ( SHEET_ID ) REFERENCES ABSENCE_PARAM_SHEET ( ABSENCE_PARAM_SHEET_ID ) ;

ALTER TABLE ABSENCE_PERIOD ADD CONSTRAINT FK_ABSENCE_PERIOD_ABSENCE_TYPE FOREIGN KEY ( ABSENCE_TYPE_ID ) REFERENCES ABSENCE_TYPE ( ABSENCE_TYPE_ID ) ;

ALTER TABLE ABSENCE_PERIOD ADD CONSTRAINT FK_ABSENCE_PERIOD_EMPLOYEE FOREIGN KEY ( EMPLOYEE_ID ) REFERENCES EMPLOYEE ( EMPLOYEEID ) ;

ALTER TABLE ABSENCE_PARAM_SHEET ADD CONSTRAINT FK_ABS_PRM_SHEET_PARENT_SHEET FOREIGN KEY ( PARENT_ID ) REFERENCES ABSENCE_PARAM_SHEET ( ABSENCE_PARAM_SHEET_ID ) ;

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_MODIF_SINCE FOREIGN KEY ( SINCEMODIFICATIONID ) REFERENCES MODIFICATION ( MODIFICATIONID ) ;

ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_MODIF_UNTIL FOREIGN KEY ( UNTILMODIFICATIONID ) REFERENCES MODIFICATION ( MODIFICATIONID ) ;

ALTER TABLE EMPL_ABS_PRM_SHEET ADD CONSTRAINT FK_EMPL_ABS_PRM_SHEET_EMPLOYEE FOREIGN KEY ( EMPLOYEE_ID ) REFERENCES EMPLOYEE ( EMPLOYEEID ) ;

ALTER TABLE EMPL_ABS_PRM_SHEET ADD CONSTRAINT FK_EMPL_ABS_PRM_SHEET_SHEET FOREIGN KEY ( ABS_PRM_SHEET_ID ) REFERENCES ABSENCE_PARAM_SHEET ( ABSENCE_PARAM_SHEET_ID ) ;

ALTER TABLE EMPLOYEE_TIMETABLE ADD CONSTRAINT FK_EMPL_TMTBL_EMPLOYEE FOREIGN KEY ( EMPLOYEE_ID ) REFERENCES EMPLOYEE ( EMPLOYEEID ) ;

ALTER TABLE EMPLOYEE_TIMETABLE ADD CONSTRAINT FK_EMPL_TMTBL_TIMETABLE FOREIGN KEY ( TIMETABLE_ID ) REFERENCES TIMETABLE ( TIMETABLE_ID ) ;

ALTER TABLE TIMETABLE_DAY ADD CONSTRAINT FK_TIMETABLE_DAY_TIMETABLE FOREIGN KEY ( TIMETABLE_ID ) REFERENCES TIMETABLE ( TIMETABLE_ID ) ;


-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            10
-- CREATE INDEX                             5
-- ALTER TABLE                             36
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
