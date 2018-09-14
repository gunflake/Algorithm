-----------------------------------------------------------------  
-- ProcedureName   : UP_AP_AR_LST
-- Description     : AP 상세 조회
-- Inner SP        : NONE  
-- Return Value    : =0->Success, <>0->Fail
-- Copyright 2009 by PayLetter Inc. All rights reserved.
-- Author          : zzangy@payletter.com, 2012-09-11
-- Modify History  : Just Created.
-----------------------------------------------------------------  
ALTER             PROCEDURE [dbo].[UP_AP_AR_LST]
@pi_intAPNo             INT         = NULL,
@pi_strApName           VARCHAR(50) = NULL,
@pi_intAgentFlag        TINYINT     = NULL,
@pi_intAgentSubFlag     TINYINT     = NULL,
@pi_intAPFlag           TINYINT     = NULL,

@pi_intSettleType       TINYINT     = NULL,
@pi_intUseState         TINYINT     = NULL,     -- 상태(1:사용, 2:미사용)        
@pi_intPageSize         INT         = 10,       -- 페이지 표시개수
@pi_intPageNo           INT         = 1,        -- 페이지 번호
@po_intRecordCnt        INT         = 0 OUTPUT  -- 전체 로우수

AS

SET NOCOUNT ON

-------------------------------------------------
--Variable Declare
-------------------------------------------------
DECLARE @v_intStartRow      INT
DECLARE @v_intStartSeqNo    VARCHAR(50)        
DECLARE @v_strSql           NVARCHAR(4000)
DECLARE @v_strSqlWhere      NVARCHAR(4000)

-------------------------------------------------
--Variable Initialize
-------------------------------------------------
SET @v_strSql = ''
SET @v_strSqlWhere = ''

-------------------------------------------------------
--1. 변수및조건문정의
-------------------------------------------------------
SET @v_intStartRow = (@pi_intPageNo - 1) * @pi_intPageSize + 1

IF ISNULL(@pi_intApNo,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.APNO = @pi_intApNo '
END
IF ISNULL(@pi_strApName,'') <> '' BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.APNAME LIKE ''%'' + @pi_strApName + ''%'' '
END
IF ISNULL(@pi_intAgentFlag,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.AGENTFLAG = @pi_intAgentFlag '
END
IF ISNULL(@pi_intAgentSubFlag,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.AGENTSUBFLAG = @pi_intAgentSubFlag '
END
IF ISNULL(@pi_intAPFlag,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.APFLAG = @pi_intAPFlag '
END
IF ISNULL(@pi_intSettleType,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.SETTLETYPE = @pi_intSettleType '
END
IF ISNULL(@pi_intUseState,0) <> 0 BEGIN
    SET @v_strSqlWhere = @v_strSqlWhere + N' AND A.USESTATE = @pi_intUseState '
END


-------------------------------------------------------
--2. 전체갯수조회
-------------------------------------------------------
SET @v_strSql = ''
SET @v_strSql = @v_strSql + N'
    SELECT  @po_intRecordCnt = COUNT(*)
    FROM    TAPMST A WITH (NOLOCK) 
    WHERE   1 = 1 '
SET @v_strSql = @v_strSql + @v_strSqlWhere 

EXEC SP_EXECUTESQL @v_strSql
    ,N'@po_intRecordCnt INT OUTPUT
      ,@pi_intAPNo INT
      ,@pi_strApName VARCHAR(50)
      ,@pi_intAgentFlag TINYINT
      ,@pi_intAgentSubFlag TINYINT
      ,@pi_intAPFlag TINYINT
      ,@pi_intSettleType TINYINT
      ,@pi_intUseState TINYINT '
    ,@po_intRecordCnt OUTPUT
    ,@pi_intAPNo = @pi_intAPNo
    ,@pi_strApName = @pi_strApName
    ,@pi_intAgentFlag = @pi_intAgentFlag
    ,@pi_intAgentSubFlag = @pi_intAgentSubFlag
    ,@pi_intAPFlag = @pi_intAPFlag
    ,@pi_intSettleType = @pi_intSettleType
    ,@pi_intUseState = @pi_intUseState



-------------------------------------------------------
--3. 리스트조회
-------------------------------------------------------
SET ROWCOUNT @pi_intPageSize

SET @v_strSql = ''
SET @v_strSql = @v_strSql + N'
    WITH  ABC AS  (
    SELECT  A.APNO
		  , A.APNAME 
		  , A.PAPNO
		  , ISNULL(B.APNAME, ''-'') AS PAPNAME
		  , A.MID
		  , A.SAFSUPPORTFLAG
		  , A.STOCKNOTICEFLAG
		  , A.SETTLETYPE
		  , CASE A.SETTLETYPE WHEN 1 THEN ''후정산'' WHEN 2 THEN ''선정산'' WHEN 3 THEN ''정산안함'' ELSE '''' END AS SETTLETYPEM
          , A.SETTLEDAYTYPE
          , CASE A.SETTLEDAYTYPE WHEN 1 THEN ''거래일'' WHEN 2 THEN ''영업일'' ELSE '''' END AS SETTLEDAYTYPEM
		  , A.AGENTFLAG
		  , CASE A.AGENTFLAG WHEN 1 THEN ''총판'' ELSE ''-'' END AS AGENTFLAGM
		  , A.AGENTSUBFLAG
		  , CASE A.AGENTSUBFLAG WHEN 1 THEN ''대리점'' ELSE ''-'' END AS AGENTSUBFLAGM
		  , A.APFLAG
		  , CASE A.APFLAG WHEN 1 THEN ''AP'' ELSE ''-'' END AS APFLAGM
		  , A.AREACODE
		  , A.BANKCODE
		  , A.ACCOUNTNO
		  , A.ACCOUNTOWNERNAME
		  , A.CNLDATE
		  , A.CNLREASON
		  , A.CNLADMINID
		  , A.CEONAME
		  , A.BIZREGNO
		  , A.PERSONNO
		  , A.ZIPCODE
		  , A.TELNO
		  , A.FAXNO
		  , A.MOBILENO
		  , A.EMAIL
		  , A.ADDRESS
		  , A.MEMO
		  , A.FTPUSERID
		  , A.ADMINID
		  , A.USESTATE
          , dbo.UF_GET_USESTATE7M(A.USESTATE) AS USESTATEM
          , CONVERT(VARCHAR(20), A.REGDATE, 120) AS REGDATE
          , CONVERT(VARCHAR(20), A.UPDDATE, 120) AS UPDDATE
          , ROW_NUMBER() OVER ( ORDER BY A.APNAME ASC) AS ROWNUM
          , A.APUNIQUEID
          , ISNULL(B.APUNIQUEID,''-'') AS PAPUNIQUEID
	FROM TAPMST A WITH(NOLOCK) LEFT OUTER JOIN TAPMST B WITH(NOLOCK) ON A.PAPNO = B.APNO
    WHERE   1 = 1 '
SET @v_strSql = @v_strSql + @v_strSqlWhere
SET @v_strSql = @v_strSql + N'
    ) '
SET @v_strSql = @v_strSql + N'
    SELECT * FROM ABC WHERE ROWNUM >= '+CAST(@v_intStartRow AS VARCHAR) + ' ORDER BY ROWNUM '

EXEC SP_EXECUTESQL @v_strSql
    ,N'@pi_intAPNo INT
      ,@pi_strApName VARCHAR(50)
      ,@pi_intAgentFlag TINYINT
      ,@pi_intAgentSubFlag TINYINT
      ,@pi_intAPFlag TINYINT
      ,@pi_intSettleType TINYINT
      ,@pi_intUseState TINYINT '
    ,@pi_intAPNo = @pi_intAPNo
    ,@pi_strApName = @pi_strApName
    ,@pi_intAgentFlag = @pi_intAgentFlag
    ,@pi_intAgentSubFlag = @pi_intAgentSubFlag
    ,@pi_intAPFlag = @pi_intAPFlag
    ,@pi_intSettleType = @pi_intSettleType
    ,@pi_intUseState = @pi_intUseState



RETURN
